package IE.D25.newlifeinau;

/***
 *  This class include all common methods
 *  Can be update in the next iterations
 *  @author Mingzhe Liu
 *  @version 1.0
 */

public class SystemUtil {
    /**
     * To calculate the distance bewteen user and school
     * @author Mingzhe Liu
     * @param userCoordinate
     * @param schoolCoordinate
     * @return result
     */
    public String distance4UserAndSchoolCal(Coordinate userCoordinate, Coordinate schoolCoordinate ) {
        String result = "";

        double longAbs = Math.abs(userCoordinate.getLongtitude() - schoolCoordinate.getLongtitude());
        double latAbs = Math.abs(userCoordinate.getLatitude() - schoolCoordinate.getLatitude());

        double dis = Math.sqrt(Math.pow(longAbs, 2) + Math.pow(latAbs, 2)) * 0.030478;

        result = new java.text.DecimalFormat("#.00").format(dis);
        return result;
    }
}
