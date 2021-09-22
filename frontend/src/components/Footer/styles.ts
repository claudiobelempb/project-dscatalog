import styled, { css } from 'styled-components';

export const FooterContainer = styled.footer`
  ${({ theme }) => css`
    /* max-width: 90%;
    margin: 0 auto;
    overflow: hidden;
    padding: 0 2rem; */
    height: 70px;
    background-color: ${theme.colors.blue_100};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;
