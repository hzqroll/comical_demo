package com.roll.comical.console.business.decorator;

/**
 * Date: 2017/7/15
 *
 * @author zongqiang.hao
 */
public abstract class Decorator extends Component {
	public void setComponent(Component component) {
		this.component = component;
	}

	protected Component component;

	@Override
	public void Operation() {
		if (component != null) {
			component.Operation();
		}
	}
}
