import java.nio.ByteBuffer;



public class Oscillator extends Thread {

    private Audio audio = new Audio();
    private Controller controller;
    private Wave wave = new Wave();

    private double freq;                                    //Set from the pitch slider
    private boolean exitThread = false;

    public Oscillator(Controller controller) {
        this.controller = controller;
    }

    //Continually fill the audio output buffer whenever it starts to get empty, SINE_PACKET_SIZE/2
        //samples at a time, until we tell the thread to exit
        public void run() {
            //Position through the sine wave as a percentage (i.e. 0-1 is 0-2*PI)
            double cyclePosition = 0;
            double cycleInc;
//            System.out.println("Requested line buffer size = " + Constants.SINE_PACKET_SIZE * 2);
//            System.out.println("Actual line buffer size = " + audio.sourceDataLine.getBufferSize());


            ByteBuffer buf = ByteBuffer.allocate(Constants.SINE_PACKET_SIZE);

            //On each pass main loop fills the available free space in the audio buffer
            //Main loop creates audio samples for sine wave, runs until we tell the thread to exit
            //Each sample is spaced 1/SAMPLING_RATE apart in time
            while (!exitThread) {
//                freq = controller.getSliderPitch().getValue();
                freq = Constants.Bb2;
                System.out.println(freq);
                cycleInc = freq/Constants.SAMPLING_RATE;
                buf.clear();

                for (int i=0; i < Constants.SINE_PACKET_SIZE/Constants.SAMPLE_SIZE; i++) {
                    buf.putShort(wave.Sin(cyclePosition));
//                    buf.putShort(wave.Tiangle(cyclePosition));

                    cyclePosition += cycleInc;
                    if (cyclePosition > 1)
                        cyclePosition -= 1;
                }

                audio.getSourceDataLine().write(buf.array(), 0, buf.position());

                try {
                    while (audio.getLineSampleCount() > Constants.SINE_PACKET_SIZE)
                        Thread.sleep(1);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            audio.getSourceDataLine().drain();
            audio.getSourceDataLine().close();
        }

        public void exit() {
            exitThread=true;
        }

}
