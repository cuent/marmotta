/**
 * Copyright (C) 2013 Salzburg Research.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kiwi.core.util;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility methods for web services
 * <p/>
 * Author: Sebastian Schaffert
 */
public class WebServiceUtil {


    /**
     * Create a JSON representation of an exception, to be returned to the client. The JSON object will be formatted
     * as follows:
     * <code>
     * {
     *     type: 'JAVA CLASS NAME',
     *     message: 'EXCEPTION MESSAGE'
     * }
     * </code>
     */
    public static String jsonErrorResponse(Exception ex) {
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("type",ex.getClass().getSimpleName());
        result.put("message",ex.getMessage());

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(result);
        } catch (IOException e) {
            // cannot occur, we write to a string
            return null;
        }

    }

    /**
     * Create a JSON representation of an exception, to be returned to the client. The JSON object will be formatted
     * as follows:
     * <code>
     * {
     *     type: 'JAVA CLASS NAME',
     *     message: 'EXCEPTION MESSAGE'
     * }
     * </code>
     */
    public static void jsonErrorResponse(Exception ex, OutputStream out) throws IOException {
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("type",ex.getClass().getSimpleName());
        result.put("message",ex.getMessage());

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out,result);

    }
}