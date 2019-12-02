package RequestResponse.Requests;

import RequestResponse.Responses.Response;

public interface Request {
    Response handle();
}
