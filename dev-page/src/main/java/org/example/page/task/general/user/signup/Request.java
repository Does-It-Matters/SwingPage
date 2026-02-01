package org.example.page.task.general.user.signup;

class Request {
//    private final ObjectMapper objectMapper = new ObjectMapper();

    void signUp(EntityGeneralUser user) {
        System.out.println("url " + user);
//        try {
//            MyHttpResponse response = Post.getResponse(url, getRequestBody(user));
//            return getSignUpResponse(response);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
    }

//    private static String getRequestBody(EntityGeneralUser user) {
//        return JsonFormatter.formatJson(user);
//    }
//
//    private Response getSignUpResponse(MyHttpResponse response) throws Exception {
//        Response signUpResponse = objectMapper.readValue(response.getBody(), Response.class);
//        signUpResponse.setStatusCode(response.getStatusCode());
//        return signUpResponse;
//    }
}
