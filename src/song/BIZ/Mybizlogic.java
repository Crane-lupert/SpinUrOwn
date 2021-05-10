package song.BIZ;

import java.util.Comparator;

import song.VO.songVO;

public class Mybizlogic implements Comparator<songVO>{

	@Override
	public int compare(songVO o1, songVO o2) {
		double o1DA = Double.parseDouble(o1.getDisAtmos());
		double o1DG = Double.parseDouble(o1.getDisgenre());
		double o2DA = Double.parseDouble(o2.getDisAtmos());
		double o2DG = Double.parseDouble(o2.getDisgenre());
		if(o1DA+o1DG
				>o2DA+o2DG) {
			return 1;
		}else {
			return -1;
		}
	}


	

}
