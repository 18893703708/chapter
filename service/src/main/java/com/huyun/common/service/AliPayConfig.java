//package com.huyun.common.service;
//import com.alipay.api.AlipayClient;
//import com.alipay.api.DefaultAlipayClient;
//
///**
// * 配置公共参数
// */
//public final class AliPayConfig {
//
//	 /**
//     * 私有的默认构造子，保证外界无法直接实例化
//     */
//    private AliPayConfig(){};
//
//    /**
//     * 支付宝网关名
//     */
//    public static String openApiDomain = "https://openapi.alipay.com/gateway.do";
//    /**
//     * APPID
//     */
//    public static String appId = "2018081361080252";
//    /**
//     *商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
//     */
//    public static String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDDEmKQx+aU5hlMjqonkrSl4NPZzPJ5boKGt7J3ZRbaBUo0S7/AKIVcLkAvMnoardFVPZnQ+ETUC0lVxeOTltI8USRlGXQCQTUwQfnlHvICnykDUu2VqdpWFfAofi3SyupjDQNjqlqEaUUGrjK4mNG8CB4dxfli0nQXRgWTr/+heLmLyIqv6AAZZkE9Os07czFbElq0xIxDcP0nCcZVAZ4Bt/V9unlqj9lDr9TqqCADgmUufxMwN8b5mQLhGybA6rrtHxX8YfThTSbvcBV0weY02mF/F2XgaFXMTl/wkN1XPqMcdSR1+p1FoIZxPcvJjKh+Le/QrGwDmhZ+6wrkMe+1AgMBAAECggEBAI1ayzXixUHsozSIxOA8PM9e5eUT0DkSTV9Vyesew7pkzuqqYV7bfhfYJAaPa0/d2K0OIGH/JdEKBLA0375ZMisnGVpxYVEo82Puyyiujew8bTnNZABpvp9W8lpFZOs0wzfXfDdCgKkmpzA6FuMRShoZP8mPZjGoExuyT+Q/Stw0Goir8lHiqf0d0azrPTaWuW/WLD30kku7vTKODgxM9ajCfkk+la7Ze5NHVgIJpANvncQP5+JQfhd1sipkMBOq7zmQ5GOMCt1k3BQd6cQJkJ8G+eh5a9uXeybHCs54e6vqNqPFFYorKhsC5kuN4b1SifVNOQ7fzgEd7sj3A3409YECgYEA/sKfyDShroF+0WhXI3uYsoo1nqMK2tRGYKkIv4soN+qk/1pGI2l5jSr4MjnSwq4GrmxBuh7Gr94t7bKBM+D8HRRkucp7RBkHbIW0oERFOrEz738zBKwqL/PTUYEc5dJqH0ntqBWqVtkEcaFlXIDKRtMDdd6M3riMP2s/WGusE7ECgYEAxAVm7fwSlJFGTqojCMwtQHnRGe4I/5Xsu52xrGsb9lVjgJegzbCIyp7tg1pm/zrKfFvPHv0QL74Qm9mJIKRLtSRhDz88NHeWVNaBBjJxJu83b9XkYL7s1Paqw/jdCjNYqEYVdOXpHnJRfWMjMgpYZ/GzeKmM26KkGTb68ol38UUCgYBGn72byrtnnQ6DDuHZPFJAbIAg0iIYN/CqqzF5qCImHi5Pe78l4f+IWvkjM1RyE7xWbjxqVE3QQ0+ILYwTzbMWfKjPuIojfqzIMOi55TMr6iPzqNeD3BZ15KoYViqkq4gv1FbF2fu2x8KrnYpz8mAg8i5rZp62v4JhsmGFKZQygQKBgGVvCjFSRGceucwRHGn8BdqcbsjFNWDUuxjm5D79eg3BZ+juDacCl/aJwQw8ppmiWY96jrZRa6PY7Y1IRz5d5lNJDPSv2z6nN2KVUVTcm1LzbLNxcmlhwvn83qbkS7VwlosVIRtJsZUwwNxqhZbqZY78MsvYqOwqwFHP8pG48xklAoGBAOKBA3MNfxHD6Si9YAJrlXyehi24dKt8+40nj1gol6pv1lZhGOPj/0pV2mzXKhnjy6FTYeSbFjj8LP+gfuyr7pWAeaiKleEfF4fJTrlyRW1Ea8IoxnspfHwOWfgBwsr6Tcx+QaFFc00wzwOnGGmp0urCDhXJJb7r+4HntoDjs+Fk";
//    /**
//     *支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
//     */
//    public static String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjIwjhoIN56735wYfYAC60/W4bTt1IEVfRGNNIwnFzePlul+RqekxLBg4OXE2VwEuT/Wfnn7vks9XPvWvX4E5/JP0239NtvkAxiheGPIDyxGDF6epLRzBQc+EKTcloslwhl52u1hTfx4PD2TVQDlku2Zd36snfUWRpZiTK3EG/wrMRSe7lHlSL9EJP9uyvei/MvGDqR3AZyn0fYI2xFVnn+EkECt8HApM+4euw2DmR4cUXHzkV+sMS56oWXceJeXrQ/b0NVaUCuF2Gvjcd8YRiia4LKbg+W8g0OjpzLtSnyTjLhRhlRBSWxIg/oapjTCHWseTXmmaDBzbFhqXkfouCwIDAQAB";
//    /**
//     * 参数类型
//     */
//    public static String PARAM_TYPE = "JSON";
//    /**
//     * 编码
//     */
//    public static String CHARSET = "UTF-8";
//
//
////    //沙河测试
////    public static String openApiDomain = "https://openapi.alipaydev.com/gateway.do";
////    public static String appId = "2016091600527224";
////    public static String privateKey ="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCxy92gESjsMcIckgv1u/e531/y9STuq4MAX9ngv/FIBjMFVjpxoD7/5YWttKZ+cAD07KAoNBrIK9CdXO+aKEw/wWays9GtRNiZ7nsOIC4ObUQOE8UtgElGiRSp7RK4fWal9rbmK+vbZJGVMplosFstqYwG1bXLPFwO1hwLGDSEpVhpby0IICfA0R3wxljUMN/hvGKowyBnqOAbmr0AIJXwBc6NMT425wOHWtppXnJbB4mGAuJ9xelDc+hwe3MgsGys+ewz7j7LnPCI+1pJRhPq4QxdrMHoLZdIA+31SO8fUBpXSx1drP9z1whtIXGOpHIuPJAfacXaILNY9XJUcaZ9AgMBAAECgf91Xx/vi2R4iGCce81pa60eB1hQC4VWCeNxW9V5iTy/T1hfLY1ndWIhjGOzSI6g6U+4YH1aDQuhGUuelruWCQRNEl+5mPvSZqCW/dg+ev/shjVnFaYVY5r79YKuqtKw+BfLeBNF37jUHI/+7mhXtBR9EHBgErTwdehP4wigSlphNaxM8nqFGbfMYBOg8DO258N7Dr4OZsyov0JnyqpWozJ30qPWlX0qQRthfNQTaUiQXoPuwEe8AVOgSoqRPiQE9dlZ2iQRV7EeiSwdfpiCRTUhpeSajmRdWRSIKnQFLcEFZk/52fFLeOe65SqInZrosjDsF4UHsgy/1ZB3UWHl+WECgYEA3PoKv0zPYb/P2U9nR626rBsWZavADCKILxZvRK3iqhMEWfU9FaPqsNMPK4Q6IlziiMbP+tCcGBqJhZBpC8z4mDgNgGbo6Q57BYrQImkJUqLeY7hup+BoyIE2TFayMBfW0qdQADHzf0uC2/gWp/47kY2/89Igg1kdqbJFR2uZT5kCgYEAzfnQUD45sPM7BQDH2B0121VPTp1cq6hGr0Y6grpNxdVmyGuvf0wt5jEfb+9h3++F1FxVbD4msehbvfomicUsqxXxvDTPKqABqmKmWrYGpuvTqcdnAend4qaesgAX2HpdgjIBS+hyAJvBZV6mmc+TI9sikYN+KBQfV/cmjQslLIUCgYEAmEllkLKxlM7owf1b0uUiaat9QvIbNwGxUqomYnFnbQgQDqLYxwohGl1J7haBLd9Pay2AdXzApkfbkIWWL0DB7b1raJsDVmHZXFdu2tgCScXed2DKOb2I2O1baz6wLD6xmJkfpBLImWiDtW6CxqGJkeTbbX/ZUkvfCmzGG9NGY7kCgYEAwo+TfwiYFBZdDIfFPdWxtsGpjRfFnnvwcMXEpRF4P0Qpt21Is9TwkjyadnBHInEtGAAzzHAUuv5CEnyFBKQUYnLzCZVUju3fROO0QYEpXWjrYbbyDPOs3NgIlRjTbW+Afmffo6UocnytvKQgeK+DTF5FE/CCLTd8t+nEJ3x8m8UCgYAB9B2uKdAxoVjVwbosc4lObfhpj5fMX3Hd/NpUPyOw93gJ8zhVZwTFjnKpwIhOpHs4xEE1MDRNph0JSXMtIn1P42VMDSjBmNrQMWltSZIaTT8YorT0DS4pHyU09F6C2gDuLNyMCb3BMnnE5VkxzAomm3DBGVtkzUg/ZIbt4JMjQg==";
////    public static String alipayPublicKey ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAscvdoBEo7DHCHJIL9bv3ud9f8vUk7quDAF/Z4L/xSAYzBVY6caA+/+WFrbSmfnAA9OygKDQayCvQnVzvmihMP8FmsrPRrUTYme57DiAuDm1EDhPFLYBJRokUqe0SuH1mpfa25ivr22SRlTKZaLBbLamMBtW1yzxcDtYcCxg0hKVYaW8tCCAnwNEd8MZY1DDf4bxiqMMgZ6jgG5q9ACCV8AXOjTE+NucDh1raaV5yWweJhgLifcXpQ3PocHtzILBsrPnsM+4+y5zwiPtaSUYT6uEMXazB6C2XSAPt9UjvH1AaV0sdXaz/c9cIbSFxjqRyLjyQH2nF2iCzWPVyVHGmfQIDAQAB";
//
//    private static class SingletonHolder{
//        /**
//         * 静态初始化器，由JVM来保证线程安全
//         */
//		private  static AlipayClient alipayClient = new DefaultAlipayClient(openApiDomain, appId,privateKey, PARAM_TYPE, CHARSET,alipayPublicKey,"RSA2");
//
//
//    }
//
//    /**
//     * 支付宝APP请求客户端实例
//     */
//    public static AlipayClient getAlipayClient(){
//        return SingletonHolder.alipayClient;
//    }
//
//
//
//}
