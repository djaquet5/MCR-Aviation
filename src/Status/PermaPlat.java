package Status;

/**
 * Permanent platinum status
 */
class PermaPlat extends Platinum {
    PermaPlat(Status status) {
        super(status);
    }

    @Override
    public void thresholdCheck() {
        //empty so that no change can occur once this status is reached
    }
}
