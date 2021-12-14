package com.chavakula.ratelimiter.rules;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Refill;

import java.time.Duration;

public enum PricingPlan {

    FREE(20), BASIC(40), PRO(100);

    private int bucketCapacity;

    PricingPlan(int bucketCapacity) {
        this.bucketCapacity = bucketCapacity;
    }

    public Bandwidth getLimit(){
        return Bandwidth.classic(bucketCapacity, Refill.intervally(bucketCapacity, Duration.ofHours(1)));
    }

    public int bucketCapacity() {
        return bucketCapacity;
    }

    /**
     * function to decide pricing plan based on API Key
     * @param apiKey
     * @return
     */
    public static PricingPlan resolvePlanFromApiKey(String apiKey){
        if(apiKey == null || apiKey.isEmpty()){
            return FREE;
        } else if (apiKey.startsWith("PRO-0001-")){
            return PRO;
        } else if (apiKey.startsWith("BAS-0002-")){
            return BASIC;
        }
        return FREE;
    }
}
