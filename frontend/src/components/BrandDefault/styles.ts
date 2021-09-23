import styled, { css } from 'styled-components';

export const BrandContainer = styled.div`
  display: flex;
  align-items: center;
  height: 100%;
  font-size: 0;
  ${({ theme }) => css`
    /* background: ${theme.colors.white_100}; */
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;
