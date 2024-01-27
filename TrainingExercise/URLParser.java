/*
 URL Parser and Builder:Create a class called URLParser that parses a URL into its 
 components (protocol, host, path, query parameters, etc.). Additionally, 
 implement a class named URLBuilder that constructs a URL from its components
 */
import java.util.HashMap;
import java.util.Map;

public class URLParser {
    private String url;

    public URLParser(String url) {
        this.url = url;
    }

    public String getProtocol() {
        int colonIndex = url.indexOf(":");
        if (colonIndex != -1) {
            return url.substring(0, colonIndex);
        }
        return null;
    }

    public String getHost() {
        int startIndex = url.indexOf("://");
        if (startIndex != -1) {
            startIndex += 3; // Move past "://"
            int endIndex = url.indexOf("/", startIndex);
            if (endIndex != -1) {
                return url.substring(startIndex, endIndex);
            } else {
                return url.substring(startIndex);
            }
        }
        return null;
    }

    public String getPath() {
        int startIndex = url.indexOf("://");
        if (startIndex != -1) {
            startIndex += 3; // Move past "://"
            int endIndex = url.indexOf("?", startIndex);
            if (endIndex != -1) {
                return url.substring(endIndex);
            }
        }
        return null;
    }

    public Map<String, String> getQueryParameters() {
        Map<String, String> queryParams = new HashMap<>();
        int questionMarkIndex = url.indexOf("?");
        if (questionMarkIndex != -1) {
            String queryString = url.substring(questionMarkIndex + 1);
            String[] pairs = queryString.split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                if (keyValue.length == 2) {
                    queryParams.put(keyValue[0], keyValue[1]);
                }
            }
        }
        return queryParams;
    }

    public static void main(String[] args) {
        String url = "https://www.example.com/path?param1=value1&param2=value2";
        URLParser urlParser = new URLParser(url);

        System.out.println("Given URL: " + url);
        System.out.println("Protocol: " + urlParser.getProtocol());
        System.out.println("Host: " + urlParser.getHost());
        System.out.println("Path: " + urlParser.getPath());
        System.out.println("Query Parameters: " + urlParser.getQueryParameters());
    }
}

class URLBuilder {
    private String protocol;
    private String host;
    private String path;
    private Map<String, String> queryParams;

    public URLBuilder() {
        this.queryParams = new HashMap<>();
    }

    public URLBuilder setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    public URLBuilder setHost(String host) {
        this.host = host;
        return this;
    }

    public URLBuilder setPath(String path) {
        this.path = path;
        return this;
    }

    public URLBuilder addQueryParam(String key, String value) {
        queryParams.put(key, value);
        return this;
    }

    public String build() {
        StringBuilder builder = new StringBuilder();

        if (protocol != null && host != null) {
            builder.append(protocol).append("://").append(host);
        }

        if (path != null) {
            builder.append(path);
        }

        if (!queryParams.isEmpty()) {
            builder.append("?");
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                builder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            builder.deleteCharAt(builder.length() - 1); // Remove the trailing "&"
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        URLBuilder urlBuilder = new URLBuilder();
        String builtURL = urlBuilder.setProtocol("https")
                                    .setHost("www.example.com")
                                    .setPath("/path")
                                    .addQueryParam("param1", "value1")
                                    .addQueryParam("param2", "value2")
                                    .build();

        System.out.println("Built URL: " + builtURL);
        System.out.println("Separate Components:");
        System.out.println("Protocol: " + urlBuilder.protocol);
        System.out.println("Host: " + urlBuilder.host);
        System.out.println("Path: " + urlBuilder.path);
        System.out.println("Query Parameters: " + urlBuilder.queryParams);
    }
}
