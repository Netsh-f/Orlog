package com.zwj;

import javax.sound.sampled.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MusicPlayer {

    static MusicPlayer startMusic1;
    static MusicPlayer startMusic2;
    static MusicPlayer gamingMusic1;

    static {
        try {
            startMusic1 = new MusicPlayer(new URL("file:sound//startMusic1.wav").getPath());
            startMusic2 = new MusicPlayer(new URL("file:sound/startMusic2.wav").getPath());
            gamingMusic1 = new MusicPlayer(new URL("file:sound/gamingMusic1.wav").getPath());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String musicPath; //��Ƶ�ļ�
    private volatile boolean run = true; //��¼��Ƶ�Ƿ񲥷�
    private Thread mainThread;  //������Ƶ�������߳�

    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceDataLine;

    public MusicPlayer(String musicPath) {
        this.musicPath = musicPath;
        prefetch();
    }

    //����׼��
    private void prefetch() {
        try {
            //��ȡ��Ƶ������
            audioStream = AudioSystem.getAudioInputStream(new File(musicPath));
            //��ȡ��Ƶ�ı������
            audioFormat = audioStream.getFormat();
            //��װ��Ƶ��Ϣ
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class,
                    audioFormat, AudioSystem.NOT_SPECIFIED);
            //ʹ�ð�װ��Ƶ��Ϣ���Info�ഴ��Դ�����У��䵱��Ƶ����Դ
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);

            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    //��������:�ر���Ƶ��ȡ����������
    protected void finalize() throws Throwable {
        super.finalize();
        sourceDataLine.drain();
        sourceDataLine.close();
        audioStream.close();
    }

    //������Ƶ:ͨ��loop���������Ƿ�ѭ������
    private void playMusic(boolean loop) throws InterruptedException {
        try {
            if (loop) {
                while (true) {
                    playMusic();
                }
            } else {
                playMusic();
                //��������в��ر�
                sourceDataLine.drain();
                sourceDataLine.close();
                audioStream.close();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    private void playMusic() {
        try {
            synchronized (this) {
                run = true;
            }
            //ͨ�������ж�ȡ��Ƶ�����������͵�������;
            //������������̣�AudioInputStream -> SourceDataLine;
            audioStream = AudioSystem.getAudioInputStream(new File(musicPath));
            int count;
            byte tempBuff[] = new byte[1024];

            while ((count = audioStream.read(tempBuff, 0, tempBuff.length)) != -1) {
                synchronized (this) {
                    while (!run)
                        wait();
                }
                sourceDataLine.write(tempBuff, 0, count);

            }

        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }


    //��ͣ������Ƶ
    private void stopMusic() {
        synchronized (this) {
            run = false;
            notifyAll();
        }
    }

    //������������
    private void continueMusic() {
        synchronized (this) {
            run = true;
            notifyAll();
        }
    }


    //�ⲿ���ÿ��Ʒ���:������Ƶ���̣߳�
    public void start(boolean loop) {
        mainThread = new Thread(new Runnable() {
            public void run() {
                try {
                    playMusic(loop);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        mainThread.start();
    }

    //�ⲿ���ÿ��Ʒ�������ͣ��Ƶ�߳�
    public void stop() {
        new Thread(new Runnable() {
            public void run() {
                stopMusic();

            }
        }).start();
    }

    //�ⲿ���ÿ��Ʒ�����������Ƶ�߳�
    public void continues() {
        new Thread(new Runnable() {
            public void run() {
                continueMusic();
            }
        }).start();
    }

    //Test
//    public static void main(String[] args) throws InterruptedException {
//
//        MusicPlayer player = new MusicPlayer("D:\\test2.wav");  //�������ֲ�����
//
//        player.start(true);  //�Կ�ʼ��ѭ������ʽ���ţ�player(false)Ϊ��ѭ������
//
//        TimeUnit.SECONDS.sleep(5);
//
//        player.stop();  //��ͣ������Ƶ
//
//        TimeUnit.SECONDS.sleep(4);
//
//        player.continues();  //������ʼ������Ƶ
//
//    }

}
