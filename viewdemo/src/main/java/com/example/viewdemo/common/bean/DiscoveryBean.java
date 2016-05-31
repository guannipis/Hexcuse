package com.example.viewdemo.common.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Hexcuse on 2016/5/9.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public class DiscoveryBean {

	/**
	 * mjia_all : http://cdn.maxjia.com/@/app/bbs/mjia_all.png
	 * topic_all : http://cdn.maxjia.com/@/app/bbs/all.png
	 */

	private ImgsBean imgs;
	/**
	 * hot_topics : [{"description":"比赛","img":"http://cdn.maxjia.com/@/app/bbs/match.png","name":"比赛","topicid":1},{"description":"","img":"http://cdn.maxjia.com/@/app/bbs/hero.png","name":"英雄","topicid":9}]
	 * imgs : {"mjia_all":"http://cdn.maxjia.com/@/app/bbs/mjia_all.png","topic_all":"http://cdn.maxjia.com/@/app/bbs/all.png"}
	 * msg :
	 * reply_timestamp : 0
	 * result : [{"click":15017,"content_type":0,"create_at":"2016-05-09 10:31:00","date":"2016-05-09 10:31:23","description":"昨日DOTA2客户端更新了 6.87C 版本，春季赛预选赛上大热的几个英雄如：赏金、末日、VS、大鱼和兽王等均遭削弱，连炼金术士也难道此劫，下面请看具体更新内容：","img_type":2,"imgs":["http://7xjamu.com2.z0.glb.qiniucdn.com/5.91QQ%E5%9B%BE%E7%89%8720160509102500.png"],"is_large_img":0,"linkid":-1,"newUrl":"http://news.maxjia.com/maxnews/app/detail/dota2/16021","newsid":"16021","source":"天辉夜魇dotaglhf","timestamp":1.462761083E9,"title":"DOTA技术流：伪随机分布是什么？","top":true,"url":"/dashboard/tempnews/news?id=11111111&game_type=dota2"},{"click":22696,"content_type":0,"date":"2016-05-09 10:38:22","description":"水友爆料老十一即将离开EHOME，而通过他昨晚的微博可以印证很可能属实。","img_type":0,"imgs":["http://7xjamu.com2.z0.glb.qiniucdn.com/5.91QQ%E5%9B%BE%E7%89%8720160509103604.png"],"linkid":-1,"newUrl":"http://news.maxjia.com/maxnews/app/detail/dota2/16023","newsid":"16023","source":"ImbaTV","timestamp":1.462761502E9,"title":"EHOME疑似人员变动 Fan取代节奏魔王","url":"http://imbatv.cn/article/4850"},{"click":20031,"content_type":0,"date":"2016-05-09 10:07:36","description":"","img_type":0,"imgs":["http://n.sinaimg.cn/games/crawl/20160503/UK8k-fxrunru8693183.jpg"],"linkid":-1,"newUrl":"http://news.maxjia.com/maxnews/app/detail/dota2/16012","newsid":"16012","source":"178DOTA2","timestamp":1.462759656E9,"title":"TS5中国区预选赛赛程：17点iG内战，20点CDEC内战","url":"http://dota2.178.com/201605/256757894379.html"},{"click":30196,"content_type":0,"date":"2016-05-09 09:44:44","description":"北京时间5月8日 东南亚战队Fnatic宣布Mushi回归FNATIC首发，并随队一起去打马尼拉特锦赛，而战队成员NET变为替补。消息一出，NET马上选择离队，并于8日晚上发长文解释自己离开的前因后果。","img_type":0,"imgs":["http://news.maxjia.com/static/imgs/dota2/20160509/img_2.jpg"],"linkid":-1,"newUrl":"http://news.maxjia.com/maxnews/app/detail/dota2/16008","newsid":"16008","source":"大竞技APP","time":"05月09日","timestamp":1.462758284E9,"title":"蹲哥Net解释离开FNC：突然被替补","url":"http://magazine.78dian.com/view/19202.html"},{"click":179774,"content_type":0,"date":"2016-05-08 21:10:01","description":"Zhou与SusieQ大婚，西恩刀塔元老们ZSMJ、狗哥、Mu等纷纷到场祝贺，他们都曾在TongFu成为队友，那么在TongFu担任过队长的Zhou神又有怎样辉煌的过去呢?","img_type":0,"imgs":["http://news.maxjia.com/static/imgs/dota2/20160508/img_23.jpg"],"linkid":-1,"newUrl":"http://news.maxjia.com/maxnews/app/detail/dota2/15991","newsid":"15991","source":"游久DOTA2","timestamp":1.462713001E9,"title":"扒一扒zhou神的历史 承载着光辉的男人","url":"http://dota2.uuu9.com/201605/518580.shtml"}]
	 * status : ok
	 */

	private String msg;
	private int reply_timestamp;
	private String status;
	/**
	 * description : 比赛
	 * img : http://cdn.maxjia.com/@/app/bbs/match.png
	 * name : 比赛
	 * topicid : 1
	 */

	private List<HotTopicsBean> hot_topics;
	/**
	 * click : 15017
	 * content_type : 0
	 * create_at : 2016-05-09 10:31:00
	 * date : 2016-05-09 10:31:23
	 * description : 昨日DOTA2客户端更新了 6.87C 版本，春季赛预选赛上大热的几个英雄如：赏金、末日、VS、大鱼和兽王等均遭削弱，连炼金术士也难道此劫，下面请看具体更新内容：
	 * img_type : 2
	 * imgs : ["http://7xjamu.com2.z0.glb.qiniucdn.com/5.91QQ%E5%9B%BE%E7%89%8720160509102500.png"]
	 * is_large_img : 0
	 * linkid : -1
	 * newUrl : http://news.maxjia.com/maxnews/app/detail/dota2/16021
	 * newsid : 16021
	 * source : 天辉夜魇dotaglhf
	 * timestamp : 1.462761083E9
	 * title : DOTA技术流：伪随机分布是什么？
	 * top : true
	 * url : /dashboard/tempnews/news?id=11111111&game_type=dota2
	 */

	private List<ResultBean> result;

	public ImgsBean getImgs() {
		return imgs;
	}

	public void setImgs(ImgsBean imgs) {
		this.imgs = imgs;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getReply_timestamp() {
		return reply_timestamp;
	}

	public void setReply_timestamp(int reply_timestamp) {
		this.reply_timestamp = reply_timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<HotTopicsBean> getHot_topics() {
		return hot_topics;
	}

	public void setHot_topics(List<HotTopicsBean> hot_topics) {
		this.hot_topics = hot_topics;
	}

	public List<ResultBean> getResult() {
		return result;
	}

	public void setResult(List<ResultBean> result) {
		this.result = result;
	}

	public static class ImgsBean {
		private String mjia_all;
		private String topic_all;

		public String getMjia_all() {
			return mjia_all;
		}

		public void setMjia_all(String mjia_all) {
			this.mjia_all = mjia_all;
		}

		public String getTopic_all() {
			return topic_all;
		}

		public void setTopic_all(String topic_all) {
			this.topic_all = topic_all;
		}
	}

	public static class HotTopicsBean {
		private String description;
		private String img;
		private String name;
		private int topicid;

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getTopicid() {
			return topicid;
		}

		public void setTopicid(int topicid) {
			this.topicid = topicid;
		}
	}

	public static class ResultBean implements Serializable{
		private int click;
		private int content_type;
		private String create_at;
		private String date;
		private String description;
		private int img_type;
		private int is_large_img;
		private int linkid;
		private String newUrl;
		private String newsid;
		private String source;
		private double timestamp;
		private String title;
		private boolean top;
		private String url;
		private List<String> imgs;

		public int getClick() {
			return click;
		}

		public void setClick(int click) {
			this.click = click;
		}

		public int getContent_type() {
			return content_type;
		}

		public void setContent_type(int content_type) {
			this.content_type = content_type;
		}

		public String getCreate_at() {
			return create_at;
		}

		public void setCreate_at(String create_at) {
			this.create_at = create_at;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getImg_type() {
			return img_type;
		}

		public void setImg_type(int img_type) {
			this.img_type = img_type;
		}

		public int getIs_large_img() {
			return is_large_img;
		}

		public void setIs_large_img(int is_large_img) {
			this.is_large_img = is_large_img;
		}

		public int getLinkid() {
			return linkid;
		}

		public void setLinkid(int linkid) {
			this.linkid = linkid;
		}

		public String getNewUrl() {
			return newUrl;
		}

		public void setNewUrl(String newUrl) {
			this.newUrl = newUrl;
		}

		public String getNewsid() {
			return newsid;
		}

		public void setNewsid(String newsid) {
			this.newsid = newsid;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public double getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(double timestamp) {
			this.timestamp = timestamp;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public boolean isTop() {
			return top;
		}

		public void setTop(boolean top) {
			this.top = top;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public List<String> getImgs() {
			return imgs;
		}

		public void setImgs(List<String> imgs) {
			this.imgs = imgs;
		}
	}
}
