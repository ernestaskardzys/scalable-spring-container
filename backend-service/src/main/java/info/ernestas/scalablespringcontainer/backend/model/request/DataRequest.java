package info.ernestas.scalablespringcontainer.backend.model.request;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DataRequest {

    private final String name;

    public DataRequest() {
        this(null);
    }

    public DataRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("name", name)
                .toString();
    }

}
