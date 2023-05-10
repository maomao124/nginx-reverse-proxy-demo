package mao.nginx_reverse_proxy_demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Project name(项目名称)：nginx-reverse-proxy-demo
 * Package(包名): mao.nginx_reverse_proxy_demo.controller
 * Class(类名): TestController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/5/10
 * Time(创建时间)： 13:44
 * Version(版本): 1.0
 * Description(描述)： 测试nginx反向代理
 */


@RestController
public class TestController
{
    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    private static final String UUID;

    private static final AtomicLong ATOMIC_LONG = new AtomicLong(0);

    static
    {
        UUID = java.util.UUID.randomUUID().toString();
        log.info("当前实例id为：" + UUID);
    }

    @GetMapping("/")
    public String ping(HttpServletRequest httpServletRequest)
    {
        long count = ATOMIC_LONG.incrementAndGet();
        String remoteAddr = httpServletRequest.getRemoteAddr();
        log.info(remoteAddr + "访问当前实例,访问计数：" + count);
        return "当前机器id：" + UUID + "<br>" + "当前访问ip：" + remoteAddr + "<br>访问计数：" + count;
    }
}
