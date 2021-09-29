import 'styled-components';

declare module 'styled-components' {
  export interface DefaultTheme {
    title: string;
    colors: {
      black_100: string;
      black_50: string;
      white_100: string;
      white_50: string;
      blue_100: string;
      blue_50: string;
      blue_rgba: string;
      red_100: string;
      red_50: string;
      green_100: string;
      green_50: string;
      gray_100: string;
      gray_50: string;
      orange_100: string;
      orange_50: string;
    };
    fonts: {
      familys: {
        primary: string;
        secundary: string;
      };
      sizes: {
        lx: string;
        mx: string;
        sx: string;
        ls: string;
        ms: string;
        ss: string;
      };
      spacings: {
        lx: string;
        mx: string;
        sx: string;
        ls: string;
        ms: string;
        ss: string;
      };
    };

    medias: {
      lx: string;
      mx: string;
      sx: string;
    };
  }
}
