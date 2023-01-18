package com.example.know.service;

import com.example.know.entity.Post;
import com.example.know.util.AjaxResult;

/**
 * @author bookWorm
 */
public interface PostService {

    /**
     * 获取最近几天最新的帖子信息
     * @param quantity 数量
     * @param day 最近day天
     * @return 返回当天帖子
     * */
    public AjaxResult getPostByDay(int quantity,int day);

    /**
     * 将热度进行最近的帖子排行
     * @param quantity 数量
     * @param day 几天 3-三天内最热 7-七天内最热
     * @return 返回目前拥有的帖子中热度排行进行返回
     * */
    public AjaxResult getHotPost(int quantity,int day);

    /**
     * 定制化查询帖子
     * @param datetime 日期
     * @param rankType 排行类型 0-默认 1-最新 2-最热
     * @param begin 起始页码
     * @param number 数量
     * @return 返回定制化查询的帖子（比如:今天最热的帖子）
     */
    public AjaxResult getCustomizationPost(String datetime,int rankType,int begin,int number);

    /**
     * 模糊查询帖子
     * @param parameter 搜索的关键字
     * @param type 查询标题-0、内容-1、标题和内容-2
     * @param postType 0-普通 1-精华
     * @param begin 起始
     * @param number 数量
     * @param rankType 最热-2、最新-1、默认-0
     * @param datetimeStart 起始日期
     * @param datetimeEnd 终止日期
     * @return 根据搜索条件进行模糊查询信息
     * */
    public AjaxResult getFuzzySearchPost(String parameter, int type,int postType, int begin, int number, int rankType, String datetimeStart,String datetimeEnd);

    /**
     * 发布新帖
     * @param post 发布的帖子信息
     * @return 自定义消息提醒
     * */
    public AjaxResult releasePost(Post post);

    /**
     * 提交审核
     * @param postId 帖子id
     * @return 自定义ajax信息
     * */
    public AjaxResult submitForReview(int postId);

    /**
     * 待审核帖子
     * @param start 起始位置
     * @param number 数量
     * @return 返回未审核的帖子
     * */
    public AjaxResult getToBeReviewed(int start,int number);

    /**
     * 审核成功，修改帖子
     * @param postId 帖子id
     * @return 返回自定义信息
     * */
    public AjaxResult auditSucceeded(int postId);

    /**
     * 审核失败，通知用户审核失败
     * @param postId 帖子id
     * @param reasonType 审核失败原因
     * @param reasonContent 原因内容
     * @return
     * */
    public AjaxResult auditFailed(int postId,int reasonType,String reasonContent);

    /**
     * 批量处理同样类型的帖子
     * @param postIds 需要进行修改的帖子ids
     * @param type 0-成功 2-失败 3-停用 4-删除
     * @return
     * */
    public AjaxResult auditOfBatch(int[] postIds,char type);

    /**
     * 单独处理的帖子
     * @param postId 需要进行修改的帖子id
     * @param type 0-成功 2-失败 3-停用 4-删除
     * @return
     * */
    public AjaxResult auditOfBatch(int postId,char type);

    /**
     * 获取帖子内容
     * @param postId 帖子id
     * @param userId 用户id
     * @param ip 用户ip
     * @return
     * */
    public AjaxResult getCompletePost(int userId,int postId,String ip);

    /**
     * 获取帖子及其作者的相关信息
     * @param flag 标志参数 1-最新 2-三天最热 3-七天最热 4-最新精华
     * @return
     * */
    public AjaxResult getSimplePostAndAuthor(int flag);

    /**
     * 获取展示帖子信息
     * @param parameter     搜索的关键字
     * @param type          查询标题-1、内容-2、标题和内容-3
     * @param plateId     板块类型数组
     * @param postType      0-普通 1-精华
     * @param begin         起始
     * @param number        数量
     * @param rankType      最热-2、最新-1、默认-0
     * @param datetimeStart 起始日期
     * @param datetimeEnd   终止日期
     * @return
     * */
    public AjaxResult getExhibitionPost(String parameter, int type,int[] plateId, char postType, int begin, int number, int rankType, String datetimeStart, String datetimeEnd);

    /**
     * 获取指定排序的帖子
     * @param flag 获取标志，0-最新 1-最新评论的帖子 2-三天最热的帖子 3-七天最热的帖子
     * @return
     * */
    public AjaxResult getPostOfExhibition(int flag);

    /**
     * 返回表内数据量
     *
     * @param day 几天内
     * @return
     */
    public Long getCountNumber(int day);
}
