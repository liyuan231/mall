package com.liyuan;

import com.github.pagehelper.PageInfo;
import com.liyuan.model.*;
import com.liyuan.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest(classes = {Application.class})
@RunWith(SpringRunner.class)
public class test {
    @Autowired
    private UserServiceImpl userService;

    //    @Test
    public void insertUser() {
        for (int i = 0; i < 94; i++) {
            MallUser mallUser = new MallUser();
            mallUser.setUsername(i + "@qq.com");
            mallUser.setMobile(String.valueOf(System.currentTimeMillis()));
            mallUser.setRole(2);
            mallUser.setUpdateTime(LocalDateTime.now());
            userService.insertSelective(mallUser);
        }

    }

    @Autowired
    private AddressServiceImpl addressService;

    //    @Test
    public void insertAddress() {
        PageInfo pageInfo = userService.querySelective(1, 100, MallUser.Column.id);
        List<MallUser> users = pageInfo.getList();
        List<Integer> userIds = new LinkedList<>();
        for (MallUser user : users) {
            userIds.add(user.getId());
        }
        for (int i = 0; i < 100; i++) {
            MallAddress mallAddress = new MallAddress();
            int n = (int) (Math.random() * userIds.size());
            mallAddress.setUserId(userIds.get(n));
            mallAddress.setMobile("mobile" + i);
            mallAddress.setName("收货人" + i + userIds.get(n));
            mallAddress.setAddressDetail("详细地址" + i);
            mallAddress.setUpdateTime(LocalDateTime.now());
            addressService.insertSelective(mallAddress);
        }
    }

    @Autowired
    private SearchHistoryServiceImpl searchHistoryService;

    //    @Test
    public void insertSearchHistory() {
        PageInfo pageInfo = userService.querySelective(1, 100, MallUser.Column.id);
        List<MallUser> users = pageInfo.getList();
        List<Integer> userIds = new LinkedList<>();
        for (MallUser user : users) {
            userIds.add(user.getId());
        }
        for (int i = 0; i < 100; i++) {
            MallSearchHistory searchHistory = new MallSearchHistory();
            int n = (int) (Math.random() * userIds.size());
            searchHistory.setUserId(userIds.get(n));
            searchHistory.setKeyword("keyword" + i);
            searchHistory.setUpdateTime(LocalDateTime.now());
            searchHistoryService.insertSelective(searchHistory);
        }
    }


    @Autowired
    private FeedbackServiceImpl feedbackService;

    //    @Test
    public void insertFeedback() {
        PageInfo pageInfo = userService.querySelective(1, 100, MallUser.Column.id);
        List<MallUser> users = pageInfo.getList();
        List<Integer> userIds = new LinkedList<>();
        for (MallUser user : users) {
            userIds.add(user.getId());
        }
        for (int i = 0; i < 100; i++) {
            MallFeedback mallFeedback = new MallFeedback();
            int n = (int) (Math.random() * userIds.size());
            mallFeedback.setUserId(userIds.get(n));
            mallFeedback.setTitle("title" + i);
            mallFeedback.setContent("content" + i);
            mallFeedback.setUpdateTime(LocalDateTime.now());
            feedbackService.insertSelective(mallFeedback);
        }
    }

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void insertFakeOrder() {
        PageInfo pageInfo = userService.querySelective(1, 100, MallUser.Column.id);
        List<MallUser> users = pageInfo.getList();
        List<Integer> userIds = new LinkedList<>();
        for (MallUser user : users) {
            userIds.add(user.getId());
        }
        for (int i = 0; i < 65; i++) {
            MallOrder order = new MallOrder();
            int n = (int) (Math.random() * userIds.size());
            int userId = userIds.get(n);
            List<MallAddress> mallAddresses = addressService.queryByUserId(userId, MallAddress.Column.id);
            if (mallAddresses.size() == 0) {
                continue;
            }
            order.setUserId(userId);
            order.setOrderStatus(0);
            order.setAftersaleStatus(0);

            order.setAddressId(mallAddresses.get(0).getId());
            order.setGoodsPrice((float) (Math.random() * 1000));
            order.setPayId("wx-pay-id" + i);
            order.setPayTime(LocalDateTime.now());
            order.setRefundType(0);
            order.setUpdateTime(LocalDateTime.now());
            orderService.insertSelective(order);

        }
    }


    @Autowired
    private CommonQuestionServiceImpl commonQuestionService;

    @Test
    public void insertCommonQuestion() {
        for (int i = 0; i < 34; i++) {
            MallIssue mallIssue = new MallIssue();
            mallIssue.setQuestion("question" + i);
            mallIssue.setAnswer("answer" + i);
            mallIssue.setUpdateTime(LocalDateTime.now());
            commonQuestionService.insertSelective(mallIssue);
        }
    }


    @Autowired
    private AdvertisementServiceImpl advertisementService;

    @Test
    public void insertAdvertisement() throws InterruptedException {
        for (int i = 100; i < 245; i++) {
            MallAd mallAd = new MallAd();
            mallAd.setName("标题" + i);
            mallAd.setContent("内容" + i);
            mallAd.setPosition(-1);
            mallAd.setLink("link" + i);
            mallAd.setStartTime(LocalDateTime.now());
            mallAd.setEndTime(LocalDateTime.now());
            mallAd.setUrl("url" + i);
            advertisementService.insertSelective(mallAd);
        }
    }

    @Autowired
    private AdministratorServiceImpl administratorService;

    @Test
    public void insertAdministrator() {
        for (int i = 0; i < 45; i++) {
            MallAdmin admin = new MallAdmin();
            admin.setUsername(i + "@qq.com");
            admin.setAvatar("avatar" + i);
            admin.setRole(-1);
            admin.setCreateTime(LocalDateTime.now());
            admin.setLastLoginTime(LocalDateTime.now().plusDays(1));
            administratorService.insertSelective(admin);
        }
    }

    @Autowired
    private StorageServiceImpl storageService;

    @Test
    public void insertStorage() {

        PageInfo pageInfo = userService.querySelective(1, 100, MallUser.Column.id);
        List<MallUser> users = pageInfo.getList();
        List<Integer> userIds = new LinkedList<>();
        for (MallUser user : users) {
            userIds.add(user.getId());
        }
        for (int i = 0; i < 45; i++) {
            MallStorage mallStorage = new MallStorage();
            mallStorage.setLocation("location" + i);
            mallStorage.setType(i);
            mallStorage.setUserId(userIds.get((int) (Math.random() * userIds.size())));
            mallStorage.setUpdateTime(LocalDateTime.now());
            storageService.insertSelective(mallStorage);
        }
    }

    @Autowired
    GoodsServiceImpl goodsService;

    @Test
    public void insertGoods() {
        for (int i = 0; i < 56; i++) {
            MallGoods mallGoods = new MallGoods();
            mallGoods.setName("商品" + i);
            mallGoods.setPrice((float) (Math.random() * 200.0));
            mallGoods.setBrief("商品简要描述" + i);
            mallGoods.setDetail("商品富文本的详细描述" + i);
            mallGoods.setUpdateTime(LocalDateTime.now());
            mallGoods.setCategoryId((int) (Math.random() * 6));
            mallGoods.setKeywords("关键字" + i);
            goodsService.insertSelective(mallGoods);
        }
    }


    @Autowired
    private CartServiceImpl cartService;

    @Test
    public void insertFakeCart() {
        PageInfo pageInfo = userService.querySelective(1, 100, MallUser.Column.id);
        List<MallUser> users = pageInfo.getList();
        List<Integer> userIds = new LinkedList<>();
        for (MallUser user : users) {
            userIds.add(user.getId());
        }
        PageInfo goodsList = goodsService.querySelective(1, 100, "update_time", "desc", MallGoods.Column.id);
        List<MallGoods> goods = goodsList.getList();
        List<Integer> goodsIds = new LinkedList<>();
        for (MallGoods good : goods) {
            goodsIds.add(good.getId());
        }
        for (int i = 0; i < 56; i++) {
            Integer userId = userIds.get((int) (Math.random() * userIds.size()));
            Integer goodsId = goodsIds.get((int) (Math.random() * goodsIds.size()));
            MallCart cart = new MallCart();
            cart.setChecked(false);
            cart.setUserId(userId);
            cart.setGoodsId(goodsId);
            cart.setNumber(i);
            cart.setProductId(-1);
            cartService.insertSelective(cart);
        }
    }
}
