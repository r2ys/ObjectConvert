### ObjectConvert是什么？
ObjectUtil是把一个对象转换成另外一个对象,转换的原则是通过原来对象的get方法获取原来对象
属性的值,再通过目标对象的set方法把原来对象的值赋值给目标对象.具有以下特点：

* 加入FiledCompare接口,自定义转换字段规则
* 加入加入ValueConverter接口,自定义值得转换规则

----------

