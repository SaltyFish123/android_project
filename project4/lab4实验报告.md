# 中山大学数据科学与计算机学院本科生实验报告

课程名称：移动应用开发

|  年级  |     大三      |  专业   |       软件工程       |
| :--: | :---------: | :---: | :--------------: |
|  学号  |  15331047   |  姓名   |       陈卓艺        |
|  电话  | 15521220710 | email | 413486687@qq.com |
| 开始日期 | 2017.10.14  |  完成   |    2017.10.15    |

## 一、 实验题目

事件处理



## 二、实现内容

【实验内容】

实现一个 Android 应用,界面呈现与实验一基本一致,要求:

(1) 该界面为应用启动后看到的第一个界面

![image](/home/joey/Documents/the_5th_semester/android_project/project4/startUI.png)

(2) 输入学号和密码的控件要求用 TextInputLayout 实现
(3) 点击图片,弹出对话框如下图:

![image](/home/joey/Documents/the_5th_semester/android_project/project4/clickPicture.png)

点击“拍摄”选项,弹出 Toast 信息“您选择了[拍摄]”;
点击“从相册选择”选项,弹出 Toast 信息“您选择了[从相册选择];
点击“取消”按钮,弹出 Toast 信息“您选择了[取消]”。
(4) 切换 RadioButton 的选项,弹出 Snackbar 提示“您选择了 xx”;
例如从选项“学生”切换到选项“教职工”,则提示“您选择了教职工”;

![image](/home/joey/Documents/the_5th_semester/android_project/project4/teacherSnackbar.png)

点击 Snackbar 上的“确定”按钮,则弹出 Toast 信息“Snackbar 的确定按钮被点击了”
(5) 点击登录按钮
依次判断学号是否为空,密码是否为空,用户名和密码是否正确(正确的学号和密
码分别为“123456”,“6666”);不正确则给出错误信息,如学号和密码都正确则提
示“登陆成功”,如图:

![image](/home/joey/Documents/the_5th_semester/android_project/project4/idEmpty.png)

![image](/home/joey/Documents/the_5th_semester/android_project/project4/passwdEmpty.png)

![image](/home/joey/Documents/the_5th_semester/android_project/project4/loginSuccessful.png)

![image](/home/joey/Documents/the_5th_semester/android_project/project4/error.png)

(6) 点击注册按钮
如果切换选项时,RadioButton 选中的是“学生”,那么弹出 Snackbar 信息“学生注册
功能尚未启用”,如果选中的是“教职工”,那么弹出 Toast 信息“教职工注册功能尚未
启用”。

![image](/home/joey/Documents/the_5th_semester/android_project/project4/logupFail.png)

## 三、实验结果

在这次实验中，个人感觉最大的问题在于对于系统控件的method不太熟悉，很多时候需要上网查一下调用了什么method以实现需求。例如如何获得view对象的attribute。这次实验UI方面和实验一差不多，主要任务是赋予对象处理事件的method。例如TextInputLayout的有关输入错误的提示可以用TextInputLayout.setError(String) 和 TextInputLayout.setErrorEnabled(boolean)来控制。还有Toast，Snackbar等具有表达信息的控件，其相关的类的数据结构以及其method的用法也有了一定的了解。然而还有很多相关知识不太了解，如View类，Snackbar类，Toast类那些数量众多的method至今为止还是相当模糊，需要花费更多时间去学习。

## 四、实验思考与感想

经过这次实验，对于android的事件的处理的一些控件有了一定的了解，个人感觉android的各种库对于Android的应用开发非常方便，种类繁多，不过我个人对于相关的app的完整的开发流程仍不太熟悉，仍需多加练习。