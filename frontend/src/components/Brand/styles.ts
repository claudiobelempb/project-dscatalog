import styled, { css } from 'styled-components';

export const BrandContainer = styled.h1`
  ${({ theme }) => css`
    font-size: 0;
    /* background: ${theme.colors.white_100}; */
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;
