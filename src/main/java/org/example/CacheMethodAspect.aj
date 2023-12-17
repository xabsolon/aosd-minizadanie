package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

public aspect CacheMethodAspect {
    private final Cache cache = new Cache();

    pointcut method() : call(* org.example.CarSearchServiceImplementation.searchCar(..));

    private String generateJsonKey(String functionName, Object[] arguments) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String argumentsJson = objectMapper.writeValueAsString(arguments);
            return functionName + "-" + argumentsJson;
        }catch (Exception e) {
            throw new RuntimeException("Error generating JSON kye", e);
        }
    }

    Object around() : method() {

        String functionName = thisJoinPointStaticPart.getSignature().toShortString();
        Object[] arguments = thisJoinPoint.getArgs();
        String key = generateJsonKey(functionName, arguments);


        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            Object val = proceed();
            cache.put(key, val);
            return val;
        }
    }
}






