import styled, { css } from 'styled-components';

export const MainContainer = styled.main`
  ${({ theme }) => css`
    /* grid-area: Main; */
    height: calc(100% - 140px);
    /* background: ${theme.colors.red_100}; */
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;
