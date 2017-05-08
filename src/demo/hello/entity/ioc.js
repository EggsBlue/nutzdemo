/*
 * 开始写上 var ioc = { ， 是为了利用 eclipse 的  javascript 编辑器的自动格式化功能
 */
var ioc = {
	huage:{
		name:'huage',
		age:19
	},
	gc:{
		args:["gc"],
		fields:{
			age:11
		}
	},
	luli:{
		args:["陆离"],
		fields:{
			age:19,
			friend:{refer:'huage'}
		}
	},
	my:{
		singleton:false,
		events : {
			create:'init',
			fetch:'fetch',
			depose:'depose'
		},
		fields:{
			name:"my",
			age:66
		}
	}
}