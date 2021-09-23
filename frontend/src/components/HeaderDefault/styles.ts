import styled, { css } from 'styled-components';

export const HeaderContainer = styled.header`
  height: 70px;
  ${({ theme }) => css`
    background: ${theme.colors.blue_100};
    @media only screen and ${theme.medias.mx} {
      height: auto;
    }
  `}
`;
