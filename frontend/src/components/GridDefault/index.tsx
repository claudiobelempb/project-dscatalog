import { ReactNode } from 'react';

import {
  GridOne,
  GridTwo,
  GridThree,
  GridFour,
  GridFive,
  GridSix,
  GridServen,
  GridEight,
  GridNine,
  GridTen,
  GridEleven,
  GridTwelve,
} from './styles';

type GridProps = {
  children: ReactNode;
  size?: 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12;
};

export const GridDefault: React.FC<GridProps> = ({ size = 1, children }) => {
  const renderGrid = () => {
    switch (size) {
      case 1:
        return <GridOne>{children}</GridOne>;
      case 2:
        return <GridTwo>{children}</GridTwo>;
      case 3:
        return <GridThree>{children}</GridThree>;
      case 4:
        return <GridFour>{children}</GridFour>;
      case 5:
        return <GridFive>{children}</GridFive>;
      case 6:
        return <GridSix>{children}</GridSix>;
      case 7:
        return <GridServen>{children}</GridServen>;
      case 8:
        return <GridEight>{children}</GridEight>;
      case 9:
        return <GridNine>{children}</GridNine>;
      case 10:
        return <GridTen>{children}</GridTen>;
      case 11:
        return <GridEleven>{children}</GridEleven>;
      case 12:
        return <GridTwelve>{children}</GridTwelve>;
      default:
        return <GridOne>{children}</GridOne>;
    }
  };

  return renderGrid();
};
