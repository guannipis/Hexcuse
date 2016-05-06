package com.example.viewdemo.common.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Hexcuse on 2016/5/6.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public class DataListViewBean implements Serializable {


	/**
	 * msg :
	 * result : {"activity_list":[{"content":"MAX62db8058","icon_url":"http://cdn.maxjia.com/activity_pngs%2Fzhaopin.png","maxjia":"maxjia://OpenShareWindow#/111111#/CCCCCC#/MAX+66255b6362db8058#/http://api.maxjia.com/static/recruit/recruit.html#/false#/MAX+66255b6362db80585df27ecf5f00542f,60f3898157286e38620f59276570636e768490538def8ffd901068a660f35417ff1f#/http://api.maxjia.com/static/recruit/recruit.html#/MAX+66255b6362db80585df27ecf5f00542f,60f3898157286e38620f59276570636e768490538def8ffd901068a660f35417ff1f#/http://cdn.maxjia.com/image/activity/recruit/recruit_share.png","need_bind_steam_id":1,"need_login":1,"title":"MAX62db8058","type":0},{"content":"62db724c949f72317075602757517239ff0c5c5e4e8e6211768482f196c44e4b6700","icon_url":"http://cdn.maxjia.com/activity_pngs%2Fhero_mmr.png","need_bind_steam_id":1,"need_login":1,"title":"62117684Dota282f196c4699c","type":1},{"content":"6bd27624699c9996ff0c592957514e4b624dff0c5f974e4b53ef8dea4e00534a","icon_url":"http://7xj7i6.com2.z0.glb.qiniucdn.com/activity_pngs%2Fbad_apple.png","need_bind_steam_id":1,"need_login":1,"title":"Dota26bd27624699c","type":1},{"content":"67e5770b621176845e935b584fe1606fff0c5168976252066790997054c14ef7503c","icon_url":"http://cdn.maxjia.com/activity_pngs/price_activity_new_2.png","need_bind_steam_id":1,"need_login":1,"title":"997054c18d444ea7","type":1},{"content":"6211548cDota24e0d5f974e0d8bf4768465454e8b..","icon_url":"http://7xj7i6.com2.z0.glb.qiniucdn.com/activity_pngs%2Fme_and_dota_new_2.png","need_bind_steam_id":1,"need_login":1,"title":"6211548cDota2","type":1},{"content":"59294e0b82f196c451fa62118f88ff0c4e005165Dota5c81670850ac","icon_url":"http://cdn.maxjia.com/activity_pngs%2Fmax_ranking.png","maxjia":"maxjia://OpenWindow#/111111#/CCCCCC#/MAX6392884c699c#/http://api.maxjia.com/api/activity/max_mmr_rankings/#/false#/MAX6392884c699c#/http://api.maxjia.com/api/activity/max_mmr_rankings/#/MAX6392884c699c#/http://cdn.maxjia.com/image/activity/max_ranking/max_ranking.png","need_bind_steam_id":1,"need_login":1,"title":"MAX6392884c699c","type":1}],"live_status":1}
	 * status : ok
	 * version : 1.0
	 */

	private String msg;
	/**
	 * activity_list : [{"content":"MAX62db8058","icon_url":"http://cdn.maxjia.com/activity_pngs%2Fzhaopin.png","maxjia":"maxjia://OpenShareWindow#/111111#/CCCCCC#/MAX+66255b6362db8058#/http://api.maxjia.com/static/recruit/recruit.html#/false#/MAX+66255b6362db80585df27ecf5f00542f,60f3898157286e38620f59276570636e768490538def8ffd901068a660f35417ff1f#/http://api.maxjia.com/static/recruit/recruit.html#/MAX+66255b6362db80585df27ecf5f00542f,60f3898157286e38620f59276570636e768490538def8ffd901068a660f35417ff1f#/http://cdn.maxjia.com/image/activity/recruit/recruit_share.png","need_bind_steam_id":1,"need_login":1,"title":"MAX62db8058","type":0},{"content":"62db724c949f72317075602757517239ff0c5c5e4e8e6211768482f196c44e4b6700","icon_url":"http://cdn.maxjia.com/activity_pngs%2Fhero_mmr.png","need_bind_steam_id":1,"need_login":1,"title":"62117684Dota282f196c4699c","type":1},{"content":"6bd27624699c9996ff0c592957514e4b624dff0c5f974e4b53ef8dea4e00534a","icon_url":"http://7xj7i6.com2.z0.glb.qiniucdn.com/activity_pngs%2Fbad_apple.png","need_bind_steam_id":1,"need_login":1,"title":"Dota26bd27624699c","type":1},{"content":"67e5770b621176845e935b584fe1606fff0c5168976252066790997054c14ef7503c","icon_url":"http://cdn.maxjia.com/activity_pngs/price_activity_new_2.png","need_bind_steam_id":1,"need_login":1,"title":"997054c18d444ea7","type":1},{"content":"6211548cDota24e0d5f974e0d8bf4768465454e8b..","icon_url":"http://7xj7i6.com2.z0.glb.qiniucdn.com/activity_pngs%2Fme_and_dota_new_2.png","need_bind_steam_id":1,"need_login":1,"title":"6211548cDota2","type":1},{"content":"59294e0b82f196c451fa62118f88ff0c4e005165Dota5c81670850ac","icon_url":"http://cdn.maxjia.com/activity_pngs%2Fmax_ranking.png","maxjia":"maxjia://OpenWindow#/111111#/CCCCCC#/MAX6392884c699c#/http://api.maxjia.com/api/activity/max_mmr_rankings/#/false#/MAX6392884c699c#/http://api.maxjia.com/api/activity/max_mmr_rankings/#/MAX6392884c699c#/http://cdn.maxjia.com/image/activity/max_ranking/max_ranking.png","need_bind_steam_id":1,"need_login":1,"title":"MAX6392884c699c","type":1}]
	 * live_status : 1
	 */

	private ResultBean result;
	private String status;
	private String version;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ResultBean getResult() {
		return result;
	}

	public void setResult(ResultBean result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public static class ResultBean {
		private int live_status;
		/**
		 * content : MAX62db8058
		 * icon_url : http://cdn.maxjia.com/activity_pngs%2Fzhaopin.png
		 * maxjia : maxjia://OpenShareWindow#/111111#/CCCCCC#/MAX+66255b6362db8058#/http://api.maxjia.com/static/recruit/recruit.html#/false#/MAX+66255b6362db80585df27ecf5f00542f,60f3898157286e38620f59276570636e768490538def8ffd901068a660f35417ff1f#/http://api.maxjia.com/static/recruit/recruit.html#/MAX+66255b6362db80585df27ecf5f00542f,60f3898157286e38620f59276570636e768490538def8ffd901068a660f35417ff1f#/http://cdn.maxjia.com/image/activity/recruit/recruit_share.png
		 * need_bind_steam_id : 1
		 * need_login : 1
		 * title : MAX62db8058
		 * type : 0
		 */

		private List<ActivityListBean> activity_list;

		public int getLive_status() {
			return live_status;
		}

		public void setLive_status(int live_status) {
			this.live_status = live_status;
		}

		public List<ActivityListBean> getActivity_list() {
			return activity_list;
		}

		public void setActivity_list(List<ActivityListBean> activity_list) {
			this.activity_list = activity_list;
		}

		public static class ActivityListBean {
			private String content;
			private String icon_url;
			private String maxjia;
			private int need_bind_steam_id;
			private int need_login;
			private String title;
			private int type;

			public String getContent() {
				return content;
			}

			public void setContent(String content) {
				this.content = content;
			}

			public String getIcon_url() {
				return icon_url;
			}

			public void setIcon_url(String icon_url) {
				this.icon_url = icon_url;
			}

			public String getMaxjia() {
				return maxjia;
			}

			public void setMaxjia(String maxjia) {
				this.maxjia = maxjia;
			}

			public int getNeed_bind_steam_id() {
				return need_bind_steam_id;
			}

			public void setNeed_bind_steam_id(int need_bind_steam_id) {
				this.need_bind_steam_id = need_bind_steam_id;
			}

			public int getNeed_login() {
				return need_login;
			}

			public void setNeed_login(int need_login) {
				this.need_login = need_login;
			}

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public int getType() {
				return type;
			}

			public void setType(int type) {
				this.type = type;
			}
		}
	}
}
