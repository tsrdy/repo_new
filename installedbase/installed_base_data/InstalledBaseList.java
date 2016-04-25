package main.java.installed_base_data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "LifecycleList")
public class InstalledBaseList {
	private List<InstalledBase> lifecycle;

	public List<InstalledBase> getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(List<InstalledBase> lifecycle) {
		this.lifecycle = lifecycle;
	}

	public InstalledBaseList(List<InstalledBase> lifecycle) {
		super();
		this.lifecycle = lifecycle;
	}

	public InstalledBaseList() {
		super();
		// TODO Auto-generated constructor stub
	}
}
