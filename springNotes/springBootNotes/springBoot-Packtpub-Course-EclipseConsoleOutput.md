```
2020-02-09 19:10:00.255 DEBUG 19856 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : GET "/farm", parameters={}
2020-02-09 19:10:00.268 DEBUG 19856 --- [nio-8080-exec-1] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to org.packt.springboot22.vid01.controller.IndexController#welcome()
2020-02-09 19:10:00.398 DEBUG 19856 --- [nio-8080-exec-1] m.m.a.RequestResponseBodyMethodProcessor : Using 'text/html', given [text/html, application/xhtml+xml, image/webp, application/xml;q=0.9, */*;q=0.8] and supported [text/plain, */*, text/plain, */*, application/json, application/*+json, application/json, application/*+json]
2020-02-09 19:10:00.400 DEBUG 19856 --- [nio-8080-exec-1] m.m.a.RequestResponseBodyMethodProcessor : Writing ["Welcome to FarmUp
Let us manage, harvest and, enjoy our gains!"]
2020-02-09 19:10:00.434 DEBUG 19856 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed 200 OK
2020-02-09 19:10:02.513 DEBUG 19856 --- [on(1)-127.0.0.1] o.s.c.e.PropertySourcesPropertyResolver  : Found key 'local.server.port' in PropertySource 'server.ports' with value of type Integer
2020-02-09 19:10:14.636 DEBUG 19856 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : GET "/", parameters={}
2020-02-09 19:10:14.662 DEBUG 19856 --- [nio-8080-exec-2] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped to ResourceHttpRequestHandler ["classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/", "/"]
2020-02-09 19:10:14.672 DEBUG 19856 --- [nio-8080-exec-2] o.s.w.s.r.ResourceHttpRequestHandler     : Resource not found
2020-02-09 19:10:14.673 DEBUG 19856 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Completed 404 NOT_FOUND
2020-02-09 19:10:14.690 DEBUG 19856 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : "ERROR" dispatch for GET "/error", parameters={}
2020-02-09 19:10:14.692 DEBUG 19856 --- [nio-8080-exec-2] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController#errorHtml(HttpServletRequest, HttpServletResponse)
2020-02-09 19:10:14.794 DEBUG 19856 --- [nio-8080-exec-2] o.s.w.s.v.ContentNegotiatingViewResolver : Selected 'text/html' given [text/html, text/html;q=0.8]
2020-02-09 19:10:14.809 DEBUG 19856 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Exiting from "ERROR" dispatch, status 404
2020-02-09 19:10:28.321 DEBUG 19856 --- [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : GET "//farm/harvest/add", parameters={}
2020-02-09 19:10:28.324 DEBUG 19856 --- [nio-8080-exec-3] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to org.packt.springboot22.vid01.controller.HarvestFormController#initForm(Model)
!!! [DEBUG] The URL mapping /form/harvest/add for the GET Request hit the initForm() method!!!
2020-02-09 19:10:28.420 DEBUG 19856 --- [nio-8080-exec-3] o.s.w.s.v.ContentNegotiatingViewResolver : Selected 'text/html' given [text/html, application/xhtml+xml, image/webp, application/xml;q=0.9, */*;q=0.8]
2020-02-09 19:10:28.424 DEBUG 19856 --- [nio-8080-exec-3] o.s.w.s.view.freemarker.FreeMarkerView   : View name 'harvest_form', model {projName=Farm Harvester}
2020-02-09 19:10:28.429 DEBUG 19856 --- [nio-8080-exec-3] o.s.w.s.view.freemarker.FreeMarkerView   : Rendering [harvest_form.ftl]
2020-02-09 19:10:28.447 DEBUG 19856 --- [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : Completed 200 OK

------------------
2020-02-10 00:23:38.472 DEBUG 24748 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Detected StandardServletMultipartResolver
2020-02-10 00:23:38.492 DEBUG 24748 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : enableLoggingRequestDetails='false': request parameters and headers will be masked to prevent unsafe logging of potentially sensitive data
2020-02-10 00:23:38.493  INFO 24748 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 21 ms
2020-02-10 00:23:38.636 DEBUG 24748 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : POST "/farm/legalDocument", parameters={}
2020-02-10 00:23:38.677 DEBUG 24748 --- [nio-8080-exec-1] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to org.packt.springboot22.vid01.controller.DocumentController#addLegalDoc(MultipartFile)
2020-02-10 00:23:38.811 DEBUG 24748 --- [nio-8080-exec-1] m.m.a.RequestResponseBodyMethodProcessor : Using 'text/plain', given [*/*] and supported [text/plain, */*, text/plain, */*, application/json, application/*+json, application/json, application/*+json]
2020-02-10 00:23:38.816 DEBUG 24748 --- [nio-8080-exec-1] m.m.a.RequestResponseBodyMethodProcessor : Writing ["Added document : ToDo - 01Feb2020.txt"]
2020-02-10 00:23:38.856 DEBUG 24748 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed 200 OK

C:\Users\ragha>curl -F "document=@C:\raghs\prsnl\ToDo - 01Feb2020.txt" http://localhost:8080/farm/legalDocument
Added document : ToDo - 01Feb2020.txt
C:\Users\ragha>

--------------------
2020-02-10 00:31:14.664 DEBUG 11300 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : GET "/farm/email", parameters={}
2020-02-10 00:31:14.676 DEBUG 11300 --- [nio-8080-exec-1] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to org.packt.springboot22.vid01.controller.EmailController#initForm()
2020-02-10 00:31:14.826 DEBUG 11300 --- [nio-8080-exec-1] o.s.w.s.v.ContentNegotiatingViewResolver : Selected 'text/html' given [text/html, application/xhtml+xml, image/webp, application/xml;q=0.9, */*;q=0.8]
2020-02-10 00:31:14.826 DEBUG 11300 --- [nio-8080-exec-1] o.s.w.s.view.freemarker.FreeMarkerView   : View name 'email_form', model {}
2020-02-10 00:31:14.830 DEBUG 11300 --- [nio-8080-exec-1] o.s.w.s.view.freemarker.FreeMarkerView   : Rendering [email_form.ftl]
2020-02-10 00:31:14.859 DEBUG 11300 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed 200 OK
2020-02-10 00:31:46.229 DEBUG 11300 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : POST "/farm/email", parameters={}
2020-02-10 00:31:46.235 DEBUG 11300 --- [nio-8080-exec-2] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to org.packt.springboot22.vid01.controller.EmailController#submitForm(String)
2020-02-10 00:31:46.396 DEBUG 11300 --- [nio-8080-exec-2] m.m.a.RequestResponseBodyMethodProcessor : Read "text/plain;charset=UTF-8" to ["from=admin@example.com
to=raghs@me.com
comment=Hi, Learning the Spring Boot Course via Packtpub.
 (truncated)...]
2020-02-10 00:31:46.494 DEBUG 11300 --- [nio-8080-exec-2] m.m.a.RequestResponseBodyMethodProcessor : Using 'text/html', given [text/html, application/xhtml+xml, image/webp, application/xml;q=0.9, */*;q=0.8] and supported [text/plain, */*, text/plain, */*, application/json, application/*+json, application/json, application/*+json]
2020-02-10 00:31:46.495 DEBUG 11300 --- [nio-8080-exec-2] m.m.a.RequestResponseBodyMethodProcessor : Writing ["from=admin@example.com
to=raghs@me.com
comment=Hi, Learning the Spring Boot Course via Packtpub.
 (truncated)...]
2020-02-10 00:31:46.545 DEBUG 11300 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Completed 200 OK
```
