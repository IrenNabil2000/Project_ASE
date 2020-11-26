package sprint;

public interface Ipresist {
    public boolean subjectValidations(String subject);
    public boolean channelValidations(String channelInput);
    public sprint.Notification create(String subj, String lanaguge, String channel);
    public void read();
    public void update(Notification n);
    public void delete(Notification n);

}
