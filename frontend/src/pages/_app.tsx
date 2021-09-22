import type { AppProps } from 'next/app';
import { GlobalStyles } from '../assets/styles/global-styles';
import '../assets/styles/global-styles.ts';
import { ThemeProvider } from 'styled-components';
import { dark } from '../assets/styles/themes/dark';

type AppPropsTheme = {
  theme: string;
};

function App({ Component, pageProps }: AppProps) {
  return (
    <ThemeProvider theme={dark}>
      <Component {...pageProps} />
      <GlobalStyles />
    </ThemeProvider>
  );
}
export default App;
