package util;

import to.protoTo.BaseTo;
import util.exception.IllegalRequestDataException;
import util.exception.NotFoundException;

public class ValidationUtil {

    private ValidationUtil() {
    }

    public static <T> T checkNotFoundWithId(T object, int id) {
        checkNotFoundWithId(object != null, id);
        return object;
    }

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + msg);
        }
    }

    public static void checkNew(BaseTo to) {
        if (!to.isNew()) {
            throw new IllegalRequestDataException(to + " must be new (id=null)");
        }
    }

    public static void assureIdConsistent(BaseTo to, int id) {
//      conservative when you reply, but accept liberally (http://stackoverflow.com/a/32728226/548473)
        if (to.isNew()) {
            to.setId(id);
        } else if (to.getId() != id) {
            throw new IllegalRequestDataException(to + " must be with id=" + id);
        }
    }
}
