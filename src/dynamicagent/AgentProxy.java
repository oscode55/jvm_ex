package dynamicagent;

/**
 * 委托类作为一个参数 传入代理类
 */
public class AgentProxy implements Interface {
    private Interface sell;
    public AgentProxy(Interface sell){
        this.sell=sell;
    }
    @Override
    public void sell(String msg) {
        sell.sell(msg);
    }
}
