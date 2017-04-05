package com.zc.happy.life.happylife.util;


import android.text.TextUtils;


public class Constants {
    /**
     * 无效节目id
     */
    public final static int INVALID_ID = -1;
    /**
     * 无效值
     */
    public static final int INVALID_NUM = -1;

    public static final String COLON_STR = ":";
    /**
     * 台宣类型
     */
//    public static final int CTG_TYPE_TX = 131;
    /**
     * 报时类型
     */
//    public static final int CTG_TYPE_BS = 132;

    public static final String KEY_AUDIO_INFO = "KEY_AUDIO_INFO";

    public final static String UNIVERSALTYPE = "UNIVERSALTYPE";
    /**
     * 一页含有10条数据
     */
    public final static int PAGE_SIZE_10 = 10;
    /**
     * 一页含有20条数据
     */
    public final static int PAGE_SIZE_20 = 20;

    /**
     * 一页含有50条数据
     */
    public final static int PAGE_SIZE_50 = 50;
    /**
     * 空字符串
     */
    public static final String BLANK_STR = "";
    public static final String DEVICE_TYPE_ANDROID = "0";

    /**
     * 与离线相关的路径 车载的路径
     **/
    public static final String OFFLINE_BASE_PATH = "kaolafm_auto";
    /**
     * 离线文件存放路径
     */
    public static final String OFFLINE_AUDIO_FOLDER = "download";
    /**
     * 离线专辑图片存放路径
     */
    public static final String OFFLINE_IMAGE_FOLDER = "image";
    /**
     * 数据库路径
     */
    public static final String OFFLINE_DATABASE_FOLDER = "database";

    /**
     * 兆字节单位
     */
    public static final long M_BITS_UNIT = 1024 * 1024;
    /**
     * 千兆字节单位
     */
    public static final long G_BITS_UNIT = 1024 * M_BITS_UNIT;
    /**
     * 传统广播下智能电台分类type
     */
    public final static int RESOURCES_TYPE_SMART_RADIO = -1;
    /**
     * 来源于本地的碎片列表
     */
    public final static String RESOURCES_TYPE_LOCAL = "-1110";
    public final static int RESOURCES_TYPE_LOCAL_INT = -1110;
    /**
     * 来源于搜索的碎片列表
     */
    public final static String RESOURCES_TYPE_SEARCH = "-1111";
    public final static int RESOURCES_TYPE_SEARCH_INT = -1111;
    /**
     * 来源于历史音乐的碎片列表
     */
    public final static String RESOURCES_TYPE_HISTORY_MUSIC = "-1112";
    public final static int RESOURCES_TYPE_HISTORY_MUSIC_INT = -1112;
    /**
     * 专辑
     */
    public final static String RESOURCES_TYPE_ALBUM = "0";
    public final static int RESOURCES_TYPE_ALBUM_INT = 0;
    /**
     * 碎片
     */
    public final static String RESOURCES_TYPE_AUDIO = "1";
    public final static int RESOURCES_TYPE_AUDIO_INT = 1;
    /**
     * 电台
     */
    public final static String RESOURCES_TYPE_PGC = "3";
    public final static int RESOURCES_TYPE_PGC_INT = 3;
    /**
     * web
     */
//    public final static String RESOURCES_TYPE_WEB = "4";
//    public final static int RESOURCES_TYPE_WEB_INT = 4;
    /**
     * 直播
     */
    public final static String RESOURCES_TYPE_LIVE = "5";
    public final static int RESOURCES_TYPE_LIVE_INT = 5;

    /**
     * 传统广播
     */
    public final static String RESOURCES_TYPE_BROADCAST = "11";
    public final static int RESOURCES_TYPE_BROADCAST_INT = 11;
    /**
     * 头条
     */
    public static final int RESOURCES_TYPE_CARD_NEWS_INT = -2;

    /**
     * 用户 搜索相关
     */
//    public static final String RESOURCES_TYPE_PERSON = "13";
    /**
     * 普通联想词 搜索相关
     */
//    public static final String RESOURCES_TYPE_WORDS = "14";

    /**
     * 发送播放、未播放 eventbugs  msg
     */
    public static final String EVENT_MSG_PLAY_STATUS = "event_msg_play_status";
    /**
     * 发送二级播放器界面点击收藏事件 eventbugs msg
     */
    public static final String EVENT_MSG_SUBSCRIBE_STATUS = "event_msg_subscribe_status";
    public static final String EVENT_MSG_EXIT = "event_msg_exit";
    /**
     * 音质设置
     */
    public static final String EVENT_TONE_SET_CHANGE = "event_msg_tone_set";
    /**
     * 退出类型:默认退出
     */
    public static final int EXIT_TYPE_DEFAULT = 0;
    /**
     * 退出类型:隐藏退出
     */
    public static final int EXIT_TYPE_HIDE = 1;
    /**
     * 退出类型:显示对话框
     */
    public static final int EXIT_TYPE_SHOW_DIALOG = 2;

//    public static String[] TYPES = new String[]{RESOURCES_TYPE_ALBUM, RESOURCES_TYPE_AUDIO, RESOURCES_TYPE_PGC, RESOURCES_TYPE_BROADCAST};

    /**
     * 无效页码
     */
    public final static int INVALID_PAGE_NUM = -1;

    /**
     * 高斯模糊默认图片高度
     */
    public static final int BLUR_DEFAULT_IMAGE_HEIGHT = 50;

    /**
     * 点击筛选onDestroyView进行的操作
     */
    public static final String GET_INDICATOR_HEIGHT = "get_indicator_height";


    /**
     * 有下一页或上一页
     */
    public static final int HAVE_PAGE = 1;
    /**
     * 没有下一页
     */
    public static final int NOT_HAVE_NEXT_PAGE = 0;

    /**
     * 碎片来源 考拉
     */
    public static final int SOURCE_KAOLA = 1;
    /**
     * 碎片来源 qq音乐
     */
    public static final int SOURCE_QQ = 6;
    /**
     * 碎片来源 喜马拉雅
     */
    public static final int SOURCE_XIMALAYA = 3;
    /**
     * 高音质码率类型
     */
    public static final int HIGHT_RATE_TYPE = 1;
    /**
     * 低音质码率类型
     */
    public static final int LOW_RATE_TYPE = 0;
    /**
     * 播放器播放上报自用默认标识
     */
    public static final String PLAYER_DEFAULT_REMARKS = "player";
    /**
     * 此类型不支持收藏error
     */
    public static final int LIKE_ERROR = -100;


    /**
     * 一般的3开头的是用户操作事件
     */
    public static final class UserOperateEventCode {
        public static final String CLICK_DOWNLOAD = "300000";
        public static final String CLICK_NAVIGATION = "300001";
        /**
         * 点击二级页播放器导航事件ID
         */
        public static final String CLICK_SECOND_PLAYER_NAVIGATION = "300002";
        public static final String CLICK_PLAY = "300003";
        public static final String CLICK_COLLECT = "300005";
        public static final String CLICK_PLAYER = "300006"; //播放器操作
        public static final String CLICK_CARD_OR_TILE = "300007"; //播放器操作
        public static final String UPGRADE = "100005";
        //        public static final String CLICK_PLAYER_SCROLL = "300008";
        public static final String CLICK_OPEN_AUTO = "300012";
        public static final String CLICK_CHOICE_PUSH = "300011";
        public static final String CLICK_PLAYER_RECOMMEND = "100004";
        //        public static final String PLAY_NOT_SMOOTH_START = "300030";
        public static final String CLICK_HEART_LIST = "300008";//点击红心播单
        public static final String ADD_OR_REMMOVE_TILE = "300009";//添加删除快捷方式
        public static final String LAUNCH = "100010";
        public static final String CLICK_QULITY = "300010";
        //        public static final String CLICK_FIRST_CATEGORY = "300011";
        /*voice*/
        public static final String VOICE_CONTROL = "100021";
        public static final String VOICE_SEARCH = "100022";
        public static final String VOICE_SELECT_RESULT = "100023";
        public static final String SEARCH_RESULT = "100024"; //搜索
        //        public static final String CUINCOM_PROXY = "300053";// 联通定向流量
        public static final String CLICK_PLAY_MODE = "300013";//点击切换模式
        public static final String CLICK_SEARCH_SUGGESTION_WORDS = "300014";//用户点击搜索联想词
        public static final String CLICK_SEARCH = "300015";//点击搜索
        public static final String CLICK_SOUND_INDEX = "100006";//语音发起点播并且播放音频前上报
        public static final String CLICK_SCAN_LOCAL = "300019";//点击扫描本地
        public static final String SOUND_SEARCH_RESULT = "300020";//搜索结果
        public static final String SOUND_OPEN_REPORT = "100012";//唤醒上报



        private UserOperateEventCode() {
        }
    }

    public static final class CommonEventCode {
        public static final String LOGIN_PLAYER_LIST_PAGE = "200001";// 进入播单列表页
        public static final String LOGIN_DETAIL_PAGE = "200002";// 进入专辑详情页
        //        public static final String LOGIN_CATEGORY_PAGE = "200004";
        public static final String LOGIN_ALL_CATEGORY_PAGE = "200005";//节目库
        public static final String LOGIN_SEARCH_PAGE = "200006";
        public static final String LOGIN_SUBSCRIBE_PAGE = "200007";
        public static final String LOGIN_HISTORY_PAGE = "200008";
        public static final String LOGIN_OFFLINE_PAGE = "200009";//进入下载页面
        public static final String LOGIN_OFFLINE_LIST_PAGE = "200010";//已离线列表页
        public static final String LOGIN_PERSON_CENTER_PAGE = "200011";
        public static final String LOGIN_ABOUT_US_PAGE = "200012";
        public static final String LOGIN_SECOND_CATEGORY_PAGE = "200013";
        public static final String PROGRAM_LIBRARY_PAGE = "200015";//节目库
        public static final String ERROR_DOWNLOAD_TASK = "994000";//下载任务失败上报
        //        public static final String DOWNLOAD_TASK_ADD_SUCCESS = "300000";//下载任务添加成功上报
        public static final String LOGIN_PLAYER_PAGE = "200014";// 进入播放器页
        public static final String LOGIN_USER_LOGIN_PAGE = "200017";//进入用户登录界面
        public static final String LOGIN_SEARCH_HISTORY_PAGE = "200018";//进入搜索页面 V2.3.3添加
        public static final String CATEGORY_SECOND_PAGE = "200019";//进入二级界面
        public static final String HOME_PAGE = "200003";//进入首页
        public static final String PAGE_SETTING= "200010";//设置界面
        public static final String PAGE_LOCAL= "200008";//本地界面
        public static final String PAGE_HISTORY_MUSIC= "200015";//历史音乐界面
        public static final String PAGE_HISTORY_RADIO= "200013";//历史电台界面

        private CommonEventCode() {
        }
    }

    public enum VoiceControl {
        PREVIOUS("上一首"),
        NEXT("下一首"),
        PLAY("播放"),
        PAUSE("暂停"),
        PLAY_RADIO("播放"),
        DOWNLOAD("下载"),
        SWITCH_RADIO("换台"),
        FORWARD("快进"),
        BACKWARD("快退"),
        EXIT("关闭考拉"),
        LAUNCH_APP("打开考拉"),
        SEARCH("搜索");

        private String detail;

        VoiceControl(String detail) {
            this.detail = detail;
        }

        public String getDetail() {
            return detail;
        }

        public VoiceControl append(String text) {
            if (!TextUtils.isEmpty(text)) {
                detail += "-" + text;
            }
            return this;
        }
    }

    /**
     * 启动类型，用于上报
     */
    public static final class LauncherType {
        public static final int TYPE_LAUNCH = 1;//正常启动
        public static final int TYPE_WIDGET = 2;//推送插播
        public static final int TYPE_FLOATING = 3;//悬浮窗
    }

    /**
     * 媒体按键类型，用于上报
     */
    public static final class MediaButtonType {
        public static final int TYPE_PAUSE = 1;
        public static final int TYPE_PLAYER = 2;
        public static final int TYPE_PRE = 3;
        public static final int TYPE_NEXT = 4;
    }

    public static final class PlayerOpt {
        // 1：点击暂停按钮；2：暂停后再点击播放；3：点击上一首；4：点击下一首；5：向左滑（下一首）；6：向右滑（上一首）；7，点击收藏；8：点击跨进15秒；
        public static final int TYPE_PAUSE = 1;
        public static final int TYPE_PLAY = 2;
        public static final int TYPE_PREV = 3;
        public static final int TYPE_NEXT = 4;
        public static final int TYPE_NEXT_SLIDE = 5;
        public static final int TYPE_PREV_SLIDE = 6;
        public static final int TYPE_LIKE = 7;
        public static final int TYPE_FORWARD = 8;
    }

    public static final class SearchType {
        // 1：点击暂停按钮；2：暂停后再点击播放；3：点击上一首；4：点击下一首；5：向左滑（下一首）；6：向右滑（上一首）；7，点击收藏；8：点击跨进15秒；
        public static final String TYPE_MANUAL = "1";
        public static final String TYPE_HISTORY = "2";
        public static final String TYPE_WORD = "3";
        public static final String TYPE_SOUND = "4";
    }

    /**
     * 唤醒类型
     */
    public static final class WakeupType {
        // 1：点击暂停按钮；2：暂停后再点击播放；3：点击上一首；4：点击下一首；5：向左滑（下一首）；6：向右滑（上一首）；7，点击收藏；8：点击跨进15秒；
        public static final String TYPE_LAUNCH = "1";//开机
        public static final String TYPE_PUSH= "2";//push
        public static final String TYPE_CRASH = "3";//异常
        public static final String TYPE_QUICK = "4";//快报
    }


}
