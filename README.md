# NaviPilgrim
Data from tracker:
POST /push.do HTTP/1.0
Host: wayker.com
Content-Type: application/x-www-form-urlencoded
Content-Length: 198
Connection: close
user-agent: Piligrim-M7 (#76)

&phoneNumber=%2B79299483184&message=ALARM KEY; $GPRMC,116653.000,A,5660.2980,N,03738.8710,E,0.00,0.00,140422,,,A,V* 39,13; GSM: 05-00-255"
+CENG: 2,
+CENG: 3,
+CENG: 4,
+CENG: 5 57;  S; Batt: 407,R

The necessary information: $GPRMC,hhmmss.ss,A,ddmm.mm,a,dddmm.mm,a,x.x,x.x,xxxx,x.x,a*

Parameters:
1. UTC of position fix, hh is hours, mm is minutes, ss.ss is seconds.
2. Status, A = Valid, V = Warning.
3. Latitude, dd is degrees. mm.mm is minutes.
4. N or S
5. Longitude, ddd is degrees. mm.mm is minutes.
6. E or W.
7. Speed over ground, knots.
8. Track made good, degrees true.
9. Date, ddmmyy.
10. Magnetic Variation, degrees.
11. E or W.
12. FAA mode indicator (NMEA 2.3 and later).
13. Nav Status (NMEA 4.1 and later) A=autonomous, D=differential, E=Estimated, M=Manual input mode N=not valid, S=Simulator, V = Valid.


