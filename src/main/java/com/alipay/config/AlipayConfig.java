package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016081500253360";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = 
    		"MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCHS65XCXcCalG1N4t5dbR5fRtydHRSORVaHhywShVqHXz3CerGuX1RyMAiMiTg0tzc2wdj4irhJ3XbGXDm7cSVijMD94qiGdchkV+ULqD0h8E31CJyhOHAs7xWcC/G1CHv+nSRmSJNoqWfZbXlRTMrDJ9AzLldXsVdZgsTfjmuzAH7Jvo5tdH0jujVBlVzyu0ShPIoI2BKk0uBtoaocHbjWwS8ZmrBGrZEaJFyH3ZFGBbdhOEfStqDJJ94UT36zVmUMu3x3xQqjYo11ZQh3td2njAf/nN07kwKbLaWb4bMmSsNuJh+KRrNgA0WMTgk0agdguokkM08r0E8GoTGvmUtAgMBAAECggEAFL7NB7mCzxMAXloa/8/FkY9WYxFqOKVaGcxeN8XUTMYiwDp8DmaoyZ6Pn26y6upKRW8sTeuDCa0kTCk1f6NbrlZXhjcxwbNWomYJEs6njXc3cFkNwyOO/h5RNavUF5e1cHel4iFp+h+DZ9KPto0K0IIJ9USu85sxhiW8cwu6yotyZ+JzdwO/TQvKlz91b75rgwJowLZlINSqWUsDsD09PNyGAB8nvAt8Dlj2IeD6gOndx0eBZmADKFQoCJxeDXWLHBgtL9hNvqtbykjvIfTYgjUBIsWqHsRzG1/vPDigZDOMWDRtDskAFqhftlXzKokavC5wLJ7WmCoFKhPB/BSJvQKBgQDEAFlNr+obTx+FIoyZLj9WVgmJ5g7XeHzan2XuoFMpU/s6panxmTv6XxWVaV9h9Q0GVjMnOXinkGOeWgd4SRwtHsLJ9x7bfoxxt/5lRPDRbzIiiXr2C9apjctYguFtCpJ9IiBiPFctSC40ATEyWD2ztr8dH4JIqK/kOmNc3XQm1wKBgQCwtiBBbcSFfAKYH8NDy164dFagjh6teULQasAmbnM39F0kvQ9Fb6DGmYJ1P8Ybcs6yPcPjeexZNAnuOL8lGmE+Wf52kcfZUaqsFAyYBv1mEazt+pxUtzXM7tWggvysOBRfAScE4X82kRpah13iyKxg5JUSAUk7kPNHmuZPEh0HmwKBgHt97MZx7ALA2486sXNiHC39j4z/EqLYG3Jzs/mhskP70fKlpmm+rneVqTe2aI6Do202qowwPcD1zI5dEw/KoKIdG4W82ghZt4t+7h5ITaLneKMiFAMqelniKRjffcECREHrWpQKiLLTI6lIhwK9bkLpBYkH7UJyZkBaOXitXx2JAoGAQ9fYcGY9IeZndJIVPIzys6xuqbuGiaFZhnzFgru63ouhyv4Ow+DEgBrlnDA81cLxGjteXpIrrF+vRFdjA1KqbO7OJCV57bRN6zzTTPa6CJrWopMpu9iO/jvfpn1Dlrb9EzB1E4mjdoak8IayA+R5UcXQeZYm0Iio7h/JNihFHusCgYBRlpohFILqVM5spDi7zm2zoYV+BgtP6YuThBeZcwMJr02PtPveqCqddwUrzWjJLAUazdjAqzG8MB9XgdkKo43jR8onoDXDU8UDFW4tX57JdQsV1jwLa1twcByMJ7F1Pl48e0322f6lumRKZWqg6WDk/tKBAfTXux8/oM7iIB3rKw==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1nXN2RszsSXwoxRu6SpCJp99mSDk9s2GJIaH+17ZkeIvKwskccehgeiaycLiNzCLf4W7UHqLUwsgC4uekZn9LwdcnoEvNAPYuvHmMK+gd16PD+JeX8Ii470/fQIWdvj9yv5QWIQBc+NJEGT6h0TIgrH+8NIgFvZ5d/g3Pa/t0NGelzkuXLGF5vC57cEpR5BgKDh7Jk5+oIbJdyruuadGMbfjMKqxFbm15cRU5UEnTTQhVDSQ/9uF20ZlbnjgAvFydsXviYDhRTlwBm7vyzo58NVDpELD7+A3eoaZXolJfuEr/LbenfC+W5GkkvDf0z49xq8yApmnycurzHvFAOWYgQIDAQAB";
    
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:80/winner/itemweb/notifyUrl";
//			"http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:80/winner/itemweb/returnUrl";
//			"http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

