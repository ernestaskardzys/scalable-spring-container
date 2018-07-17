package info.ernestas.scalablespringcontainer.gateway.model.request;

public class DataRequest {

    private final String id;
    private final String name;

    public DataRequest() {
        this(null, null);
    }

    public DataRequest(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
