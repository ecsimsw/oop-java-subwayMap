package subway.domain;

public class Order {
    private int order;

    public Order(int order, Line line){

        if(line.getStations().size() < order){
            throw new IllegalArgumentException("순서는 노선의 역 개수를 초과할 수 없습니다.");
        }

        if(order<0){
            throw new IllegalArgumentException("순서는 양수만 가능 합니다.");
        }
        this.order= order;
    }

    public int getOrder(){
        return order;
    }
}
