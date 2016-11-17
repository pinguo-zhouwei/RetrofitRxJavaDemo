###Retrofit + RxJava ＋ OkHttp 让网络请求变的简单

博客地址：
1，[Retrofit + RxJava ＋ OkHttp 让网络请求变的简单-基础篇](http://www.jianshu.com/p/5bc866b9cbb9)
2,[Retrofit + RxJava ＋ OkHttp 让网络请求变的简单-封装篇](http://www.jianshu.com/p/811ba49d0748)

####添加一个新的网络请求实现一下两步：

#####一，添加一个业务Loader 
代码如下：

```
/**
 * Created by zhouwei on 16/11/17.
 */

public class GankLoader extends ObjectLoader {
    private static final String GANK_URL = "http://gank.io/api/data/福利/50/1";
    private GankService mGankService ;
    public GankLoader(){
        mGankService = RetrofitServiceManager.getInstance().create(GankService.class);
    }

    /**
     * 获取干货列表
     * @return
     */
    public Observable<List<GankEntry>> getGankList(){
        return observe(mGankService.getGank(GANK_URL)).map(new Func1<GankResp, List<GankEntry>>() {
            @Override
            public List<GankEntry> call(GankResp gankResp) {
                return gankResp.results;
            }
        });
    }


    public interface GankService{
        /**
         *
         * @param url
         * @param
         * @param
         * @return
         */
        @GET
        Observable<GankResp> getGank(@Url String url/*, @Path("count")int count,@Path("page")int page*/);
    }
}


```

##### 二，在Activity/Fragment 中，生成Loader 实例，调用方法获取结果
代码如下：

```
mGankLoader = new GankLoader();
```

```

private void getGankList(){
        Subscription subscription = mGankLoader.getGankList().subscribe(new Action1<List<GankEntry>>() {
            @Override
            public void call(List<GankEntry> gankEntries) {
                Log.i("FK","gank size:"+gankEntries.size());
                mAdapter.setData(gankEntries);
                mAdapter.notifyDataSetChanged();
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
            }
        });

        addSubscription(subscription);
    }
```

最后，示例API 的效果图：

1,福利列表（数据来自干货集中营）：

![福利](image/award_list.png)

2,电影列表（数据来自豆瓣）：

![福利](image/movie_list.png)

