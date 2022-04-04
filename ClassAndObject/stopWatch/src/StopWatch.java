import java.time.Duration;
import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;

    public StopWatch(){
    }

    public LocalTime getStartTime() {
        return this.startTime.now();
    }

    public LocalTime getEndTime() {
        return this.endTime.now();
    }

    public LocalTime start() {
       return this.startTime = getStartTime();
    }

    public LocalTime stop() {
       return this.endTime = getEndTime();
    }
    public long getElapsedTime(){
        return Duration.between(startTime,endTime).toMillis();
    }
}
