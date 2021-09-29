import styled, { css } from 'styled-components';

export const MainContainer = styled.main`
  height: calc(100% - 140px);
  ${({ theme }) => css`
    /* grid-area: Main; */

    /* background: ${theme.colors.red_100}; */
    @media only screen and ${theme.medias.mx} {
      height: 100%;
    }
  `}
`;
