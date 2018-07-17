package info.ernestas.scalablespringcontainer.gateway.model.response;

public class DataResponse {

    private final String status;

    public DataResponse() {
        this(null);
    }

    public DataResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
