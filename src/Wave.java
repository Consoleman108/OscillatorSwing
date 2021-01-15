public class Wave {
    public short Sin(double cyclePosition) {
        return (short)(Short.MAX_VALUE * Math.sin(2 * Math.PI * cyclePosition));
    }

    public short Tiangle(double cyclePosition) {
        return (short) ( ( (2 * Short.MAX_VALUE)/Math.PI ) * Math.asin( Math.sin( 2 * Math.PI * cyclePosition)));
    }
}
