import { DefaultTheme } from 'styled-components';
export const dark: DefaultTheme = {
  title: 'dark',

  colors: {
    white_100: '#FFFFFF',
    white_50: '#FFFFFF',
    black_100: '#000000',
    black_50: '#263238',
    gray_100: '#707070',
    orange_100: '#EE6B26',
    orange_50: '#F7931B',
    blue_100: '#407BFF',
    blue_50: '#4E41F0',
    blue_rgba: 'rgba(51, 87, 156, 1.00)',
    red_100: '#E44C4E',
    red_50: '#E44C4E',
    green_100: '#E44C4E',
    green_50: '#E44C4E',
    gray_50: '#E44C4E',
  },

  fonts: {
    familys: {
      primary: "'Open Sans', sans-serif",
      secundary: "'Open Sans', sans-serif",
    },
    sizes: {
      lx: '7.594rem',
      mx: '5.063rem',
      sx: '3.375rem',
      ls: '2.25rem',
      ms: '1.5rem',
      ss: '1rem',
    },
    spacings: {
      lx: '7.594rem',
      mx: '5.063rem',
      sx: '3.375rem',
      ls: '2.25rem',
      ms: '1.5rem',
      ss: '1.25rem',
    },
  },

  medias: {
    lx: '(max-width: 1024px)',
    mx: '(max-width: 768px)',
    sx: '(max-width: 560px)',
  },
};
