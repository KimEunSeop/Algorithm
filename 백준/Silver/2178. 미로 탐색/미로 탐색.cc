#include <iostream>
#include <utility>
#include <string>
#include <queue>

using namespace std;

int main(){
	
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	string arr[101]; // 미로
	int dist[101][101]; // 이동 거리
	bool chk[101][101]; // 방문 체크
	
	queue<pair<int,int> > Q;
	int n,m;

	cin >> n >> m;
	
	int dx[4] = {1,0,-1,0};
	int dy[4] = {0,1,0,-1};
	
	for(int i=0; i<n; i++){
		cin >> arr[i];	
	}
	
	dist[0][0] = 1;
	Q.push({0,0});
	chk[0][0] = 1;
	
	while(!Q.empty()){
		
		pair<int,int> cur = Q.front();
		Q.pop();
		
		for(int dir=0; dir<4; dir++){ 
			int nx = cur.first + dx[dir];
			int ny = cur.second + dy[dir];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >=m)
				continue;
				
			if(arr[nx][ny]=='0' || chk[nx][ny])
				continue;
			
			dist[nx][ny] = dist[cur.first][cur.second] + 1;
			Q.push({nx,ny});
			chk[nx][ny] = 1;
			
		}
	}

	cout << dist[n-1][m-1];
	
	return 0; 

} 