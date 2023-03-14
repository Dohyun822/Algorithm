class Solution {
	private int remainDelivery;
	private int remainPickup;
	private int Pickuplasthouse;
	private int Deliverylasthouse;

	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		Deliverylasthouse = 0;// 배달해야하는 집 중 마지막 인덱스
		Pickuplasthouse = 0;// 수거해야하는 집 중 마지막 인덱스
		remainDelivery = 0; // 배달할 상자 수
		remainPickup = 0; // 수거할 상자 수
		for (int i = 0; i < n; i++) {
			if (deliveries[i] != 0) {
				Deliverylasthouse = i;
				remainDelivery += deliveries[i];
			}
			if (pickups[i] != 0) {
				Pickuplasthouse = i;
				remainPickup += pickups[i];
			}
		}
		while (remainDelivery > 0 || remainPickup > 0) {
			int move = Math.max(Deliverylasthouse + 1, Pickuplasthouse + 1);
			answer += move * 2;
			int canDelivery = cap; // 배달 가능 수
			int canPickup = cap; // 수거 가능 수

			while (canDelivery > 0 && remainDelivery > 0) {
				deliveries[Deliverylasthouse]--;
				canDelivery--;
				remainDelivery--;
				if (remainDelivery == 0) {
					Deliverylasthouse = 0;
					break;
				}
				if (deliveries[Deliverylasthouse] == 0) {
					for (int i = Deliverylasthouse; i >= 0; i--) {
						if (deliveries[i] != 0) {
							Deliverylasthouse = i;
							break;
						}
					}
				}
			}

			while (canPickup > 0 && remainPickup > 0) {
				pickups[Pickuplasthouse]--;
				canPickup--;
				remainPickup--;
				if (remainPickup == 0) {
					Pickuplasthouse = 0;
					break;
				}
				if (pickups[Pickuplasthouse] == 0) {
					for (int i = Pickuplasthouse; i >= 0; i--) {
						if (pickups[i] != 0) {
							Pickuplasthouse = i;
							break;
						}
					}
				}
			}

		}

		return answer;
	}
}