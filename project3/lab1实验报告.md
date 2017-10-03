# 中山大学数据科学与计算机学院本科生实验报告

课程名称：移动应用开发

|  年级  |     大三      |  专业   |       软件工程       |
| :--: | :---------: | :---: | :--------------: |
|  学号  |  15331047   |  姓名   |       陈卓艺        |
|  电话  | 15521220710 | email | 413486687@qq.com |
| 开始日期 | 2017.10.02  |  完成   |    2017.10.03    |

## 一、 实验题目

基本UI界面设计



## 二、实现内容

实现一个 Android 应用,界面呈现如下效果:

![image](/home/joey/Documents/the_5th_semester/android_project/project3/UI.png)

要求:

(1)该界面为应用启动后看到的第一个界面
(2)各控件的要求如下:
要求只用一个 ConstraintLayout 实现整个布局;
标题字体大小 20sp,与顶部距离 20dp,居中;
2/11图片与标题的间距为 20dp,居中;输入框整体距屏幕右边间距 20dp,上下两栏间距 20dp,内
容(包括提示内容)如图所示,内容字体大小 18sp;
学号对应的 EditText 只能输入数字,密码对应的 EditText 输入方式为密码;
两个单选按钮整体居中,字体大小 18sp,间距 10dp,默认选中的按钮为第一个;
两个按钮整体居中,与上方控件间距 20dp,按钮间的间距 10dp,文字大小 18sp。按钮背景框左
右边框与文字间距 10dp,上下边框与文字间距 5dp,圆角半径 10dp,背景色为#3F51B5
(3)使用的布局和控件:ConstraintLayout、TextView、EditText、Button、ImageView、RadioGroup、
RadioButton



## 三、实验结果

在这次实验中，我主要根据实验的要求来进行设计的顺序，将UI的元素自上而下得设计出来。根据上下控件之间的相对位置进行布局。

得知对于 **0dp** 于 **layout_width** 和 **layout_height** 的影响， 控件会自动根据位置填充。

**layout_constraint[本源位置]_[目标位置]="[目标ID]“**, 例如:
**app:layout_constraintBottom_toBottomOf=“parent“**
约束当前View的底部至目标View的底部, 目标View是constraintLayout.
即, 把当前View的底部对齐到constraintLayout的底部.

主要的activity_main.xml文件代码如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.joey.lab1_code.MainActivity">

    <TextView
        android:id="@+id/subtitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="20sp"
        android:layout_marginTop="20dp"
        android:text="中山大学学生信息系统"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"/>

    <ImageView
        android:id="@+id/sysu"
        android:src="@mipmap/sysu"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/subtitle"/>

    <TextView
        android:id="@+id/idNumber"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="20dp"
        android:textSize="18sp"
        android:text="学号："
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/sysu" />

    <TextView
        android:id="@+id/passwd"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="20dp"
        android:textSize="18sp"
        android:text="密码："
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/idNumber" />

    <EditText
        android:id="@+id/idInput"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:inputType="number"
        android:hint="请输入学号"
        android:textSize="18sp"
        android:layout_marginRight="20dp"
        android:layout_marginLeft="20dp"
        app:layout_constraintLeft_toRightOf="@+id/idNumber"
        app:layout_constraintTop_toTopOf="@+id/idNumber"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintBottom_toBottomOf="@+id/idNumber" />

    <EditText
        android:id="@+id/passwdInput"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:inputType="textPassword"
        android:hint="请输入密码"
        android:textSize="18sp"
        android:layout_marginRight="20dp"
        android:layout_marginLeft="20dp"
        app:layout_constraintLeft_toRightOf="@+id/passwd"
        app:layout_constraintTop_toTopOf="@+id/passwd"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintBottom_toBottomOf="@+id/passwd"/>

    <RadioGroup
        android:id="@+id/radioGroup"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginTop="20dp"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/passwdInput">

        <RadioButton
            android:id="@+id/students"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text=" 学生"
            android:textSize="18sp"
            android:checked="true"/>

        <RadioButton
            android:id="@+id/teachers"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text=" 教职工"
            android:textSize="18sp"
            android:layout_marginLeft="10dp" />

    </RadioGroup>

    <Button
        android:id="@+id/signIn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="登录"
        android:textSize="18sp"
        android:background="@drawable/button"
        android:layout_marginTop="20dp"
        android:layout_marginRight="10dp"
        app:layout_constraintHorizontal_chainStyle="packed"
        app:layout_constraintTop_toBottomOf="@+id/radioGroup"
        app:layout_constraintRight_toLeftOf="@+id/signUp"
        app:layout_constraintLeft_toLeftOf="parent" />

    <Button
        android:id="@+id/signUp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="注册"
        android:textSize="18sp"
        android:background="@drawable/button"
        android:layout_marginTop="20dp"
        android:layout_marginLeft="10dp"
        app:layout_constraintLeft_toRightOf="@id/signIn"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/radioGroup"/>


</android.support.constraint.ConstraintLayout>
```

在本次实验中，感觉最大的困难在于一开始不是很了解相关属性的作用，例如不知如何将同一行的不同控件对齐，后来才发现可以使用**app:layout_constraintTop_toTopOf**和**app:layout_constraintBottom_toBottomOf**对齐同一行的控件的id来实现对齐，就如这次试验中**密码：**控件和**请输入密码**控件一样。



## 四、实验思考与感想

经过这次实验，对于android的UI设计的各种布局和控件属性有了一些初步的了解，但还不是太熟练，对于UI设计的方面也需要努力。
