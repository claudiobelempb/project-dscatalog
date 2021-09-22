import styled, { css } from 'styled-components';

export const HeaderContainer = styled.header`
  ${({ theme }) => css`
    height: 70px;
    background: ${theme.colors.blue_100};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;
