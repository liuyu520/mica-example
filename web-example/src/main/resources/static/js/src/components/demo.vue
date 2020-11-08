<template>
    <div>
        <van-search v-model="value" placeholder="请输入搜索关键词"></van-search>
        <avue-swipe :option="option" @click="handleClick"></avue-swipe>
        <avue-grid :option="option1" @click="handleClick"></avue-grid>
        <avue-cell :option="option2" empty-text="没有发现数据"
                   @click="handleClick"></avue-cell>
        <avue-tabbar :option="option3" @click="handleClick"></avue-tabbar>
    </div>
</template>
<script>
export default {
    data() {
        return {
            search: '',
            option: {
                // autoplay:5000,
                // loop:false,
                list: [{
                    title: '这是标题2',
                    url: '/vant/mobile.htm',
                    value: 'https://img.yzcdn.cn/vant/apple-1.jpg',
                }, {
                    title: '这是标题3',
                    url: '/vant/mobile.htm',
                    value: 'https://img.yzcdn.cn/vant/apple-2.jpg',
                }]
            },
            option1: {
                // span: 12,
                // round: 10,
                list: [{
                    url: '/vant/mobile.htm',
                    title: '我是菜单1',
                    color: '#67C23A',
                    url: '/vant/mobile.htm',
                    icon: 'like-o'
                }, {
                    url: '/vant/mobile.htm',
                    title: '我是菜单2',
                    color: '#409EFF',
                    url: '/vant/mobile.htm',
                    icon: 'star-o'
                }, {
                    url: '/vant/mobile.htm',
                    title: '我是菜单3',
                    color: '#E6A23C',
                    url: '/vant/mobile.htm',
                    icon: 'phone-o'
                }, {
                    url: '/vant/mobile.htm',
                    title: '我是菜单4',
                    color: '#F56C6C',
                    url: '/vant/mobile.htm',
                    icon: 'flag-o'
                }, {
                    url: '/vant/mobile.htm',
                    title: '我是菜单5',
                    color: '#F56C6C',
                    url: '/vant/mobile.htm',
                    icon: 'flower-o'
                }, {
                    url: '/vant/mobile.htm',
                    title: '我是菜单6',
                    color: '#E6A23C',
                    url: '/vant/mobile.htm',
                    icon: 'brush-o'
                }, {
                    url: '/vant/mobile.htm',
                    title: '我是菜单7',
                    color: '#67C23A',
                    url: '/vant/mobile.htm',
                    icon: 'bulb-o'
                }, {
                    url: '/vant/mobile.htm',
                    title: '我是菜单8',
                    color: '#409EFF',
                    url: '/vant/mobile.htm',
                    icon: 'user-o'
                }]
            },
            option2: {
                size: 'large',
                list: [{
                    label: '分组1',
                    prop: 'group1',
                    column: [{
                        title: '菜单1',
                        prop: 'text1',
                        value: '内容1',
                        children: {
                            span: 24,
                            column: [{
                                title: '创建日期',
                                value: '2020-02-02 02:02:02',
                            }, {
                                title: '创建日期',
                                value: '2020-02-02 02:02:02',
                            }]
                        },
                        // isLink: true,
                        url: '/vant/mobile.htm',
                        icon: 'location-o'
                    }, {
                        title: '菜单2',
                        value: '内容2',
                        isLink: true,
                        prop: 'text2',
                        url: '/vant/mobile.htm',
                        icon: 'location-o'
                    }]
                }, {
                    label: '分组2',
                    prop: 'group2',
                    column: [{
                        title: '菜单3',
                        value: '内容3',
                        isLink: true,
                        prop: 'text3',
                        url: '/vant/mobile.htm',
                        icon: 'location-o'
                    }, {
                        title: '菜单4',
                        value: '内容4',
                        isLink: true,
                        prop: 'text4',
                        url: '/vant/mobile.htm',
                        icon: 'location-o'
                    }]
                }]
            },
            option3: {
                // span: 12,
                // round: 10,
                list: [{
                    url: '/vant/mobile.htm',
                    title: '菜单1',
                    color: '#67C23A',
                    url: '/vant/mobile.htm',
                    icon: 'like-o'
                }, {
                    url: '/vant/mobile.htm',
                    title: '菜单2',
                    color: '#409EFF',
                    url: '/vant/mobile.htm',
                    icon: 'star-o'
                }, {
                    url: '/vant/mobile.htm',
                    title: '菜单3',
                    color: '#E6A23C',
                    url: '/vant/mobile.htm',
                    icon: 'phone-o'
                }, {
                    url: '/vant/mobile.htm',
                    title: '菜单4',
                    color: '#F56C6C',
                    url: '/vant/mobile.htm',
                    icon: 'flag-o'
                }]
            }
        }
    },
    methods: {
        handleClick(item) {
            console.log(item)
        }
    }
}
</script>
