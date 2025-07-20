import java.util.*;

class Solution {
    static class Song implements Comparable<Song> {
        int id;
        int playCount;

        public Song(int id, int playCount) {
            this.id = id;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(Song song) {
            if (this.playCount != song.playCount) {
                return song.playCount - this.playCount;
            }
            return this.id-song.id; //횟수 같으면
        }
    }

    static class Genre implements Comparable<Genre> {
        String name;
        int plays;

        public Genre(String name, int plays) {
            this.name = name;
            this.plays = plays;
        }

        @Override
        public int compareTo(Genre genre) {
            return genre.plays -this.plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>(); //장르별 총 노래 play 횟 수
        Map<String, List<Song>> songMap= new HashMap<>(); //장르에 어떤 노래 있는지

        for (int i = 0; i < genres.length;i++) { //맵에 입력
            String genre = genres[i];
            int play = plays[i];

            genreMap.put(genre, genreMap.getOrDefault(genre, 0) + play);//있으면 더해
            //노래도 넣어
            if(!songMap.containsKey(genre)) {
                songMap.put(genre, new ArrayList<>());
            }
            
            songMap.get(genre).add(new Song(i, play));
        }
        
        //맵 정보로 장르 정렬

        List<Genre> genreList = new ArrayList<>();
        for (String genreName : genreMap.keySet()) {
            genreList.add(new Genre(genreName, genreMap.get(genreName)));
        }
        
        Collections.sort(genreList);

        List<Integer> answer = new ArrayList<>();
        for (Genre genre : genreList) {
            //장르별 노래 정렬
            List<Song> songs = songMap.get(genre.name);
            Collections.sort(songs);
            
        
            // //상위 2개
            // answer.add(songs.get(0).id);
            // answer.add(songs.get(1).id);
            
            if(songs.size()>=2) {
                answer.add(songs.get(0).id);
                answer.add(songs.get(1).id);
            } else{
                answer.add(songs.get(0).id);
            }
        }
        
        int[] arr = new int[answer.size()];
        for(int i =0 ; i < answer.size() ; i++) {
            arr[i] = answer.get(i).intValue();
        }
        
        return arr;
    }
}
