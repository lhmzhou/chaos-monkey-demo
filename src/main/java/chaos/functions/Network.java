package com.chaos.functions;

public class Network {
    /**
     * Method injects network failure using a percentage value of requests to be aborted and an http status.
     * @param abortPercent min = 0 max = 100, specifies percentage of requests to be aborted
     * @param httpStatus must be valid http status code
     */
    public static void abortRequests(int abortPercent, int httpStatus) {
        System.out.print("Aborting " + abortPercent + "% of requests.");

        String httpFaultInjection = "fault.http.abort.abort_percent=" + abortPercent +
                "&" + "fault.http.abort.http_status=" + httpStatus;

        RuntimeConfig.modifyRuntimeConfig(httpFaultInjection);
    }

    /**
     * Method injects http delay using a percentage value of requests to be delayed and a delay duration.
     * @param delayPercent min = 0, max =100, percentage of requests to be delayed
     * @param delayDuration in milliseconds, duration of delay to be injected into http requests
     */
    public static void injectHttpDelay(int delayPercent, int delayDuration) {
        System.out.print("Injecting http delay to " + delayPercent + "% of requests with delay of"
                + delayDuration + "ms");

        String httpDelayInjection = "fault.http.delay.fixed_delay_percent=" + delayPercent +
                "&" + "fault.http.delay.fixed_duration_ms=" + delayDuration;

        RuntimeConfig.modifyRuntimeConfig(httpDelayInjection);
    }

    public static void clear() {
        System.out.println("clearing network runtime configs...");
        RuntimeConfig.modifyRuntimeConfig("fault.http.abort.abort_percent=&fault.http.abort.http_status=" +
                "&fault.http.delay.fixed_delay_percent=&fault.http.delay.fixed_duration_ms=");
    }

}